package com.maple.statuslayout.status

import android.content.Context
import android.support.annotation.LayoutRes
import android.util.AttributeSet
import android.util.SparseArray
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import android.text.TextUtils
import android.widget.ImageView


/**
 * author: gaogq
 * time: 2019/5/17 11:31
 * description:
 */
class RootFrameLayout : FrameLayout {


    companion object {
        /**
         * loading 加载id
         */
        const val LAYOUT_LOADING_ID: Int = 1
        /**
         * 内容 id
         */
        const val LAYOUT_CONTENT_ID: Int = 2
        /**
         * 异常 id
         */
        const val LAYOUT_ERROR_ID: Int = 3
        /**
         * 网络异常 id
         */
        const val LAYOUT_NETWORK_ERROR_ID: Int = 4
        /**
         * 空数据 id
         */
        const val LAYOUT_EMPTYDATA_ID: Int = 5
    }

    /**
     *  存放布局集合
     */
    private val layoutSparseArray = SparseArray<View>()

    /**
     * 布局管理器
     */
    private var mStatusLayoutManager: StatusLayoutManager? = null

    constructor (context: Context?) : this(context, null)
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        initView(context, attrs, defStyleAttr)
    }

    private fun initView(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) {

    }

    fun setStatusLayoutManager(statusLayoutManager: StatusLayoutManager) {
        mStatusLayoutManager = statusLayoutManager
        addAllLayoutToRootLayout()
    }

    private fun addLayoutResId(@LayoutRes layoutResId: Int, id: Int) {
        val resView: View = LayoutInflater.from(mStatusLayoutManager?.context).inflate(layoutResId, null)
        layoutSparseArray.put(id, resView)
        addView(resView)
    }

    private fun addAllLayoutToRootLayout() {
        if (mStatusLayoutManager?.contentLayoutResId != 0) {
            addLayoutResId(mStatusLayoutManager!!.contentLayoutResId!!, RootFrameLayout.LAYOUT_CONTENT_ID)
        }

        if (mStatusLayoutManager?.loadingLayoutResId != 0) {
            addLayoutResId(mStatusLayoutManager!!.loadingLayoutResId!!, RootFrameLayout.LAYOUT_LOADING_ID)
        }

        if (mStatusLayoutManager?.emptyDataVs != null) {
            addView(mStatusLayoutManager!!.emptyDataVs)
        }
        if (mStatusLayoutManager?.errorVs != null) {
            addView(mStatusLayoutManager!!.errorVs)
        }
        if (mStatusLayoutManager?.netWorkErrorVs != null) {
            addView(mStatusLayoutManager!!.netWorkErrorVs)
        }
    }

    /**
     * 根据ID显示隐藏布局
     * @param id
     */
    private fun showHideViewById(id: Int) {
        for (i:Int in 0 until layoutSparseArray.size()) {
            val key:Int = layoutSparseArray.keyAt(i)
            val valueView:View = layoutSparseArray.valueAt(i)
            //显示该view
            if (key == id) {
                valueView.visibility = View.VISIBLE
                if (mStatusLayoutManager?.onShowHideViewListener != null) mStatusLayoutManager?.onShowHideViewListener?.onShowView(
                    valueView,
                    key
                )
            } else {
                if (valueView.visibility != View.GONE) {
                    valueView.visibility = View.GONE
                    if (mStatusLayoutManager?.onShowHideViewListener != null) mStatusLayoutManager?.onShowHideViewListener?.onHideView(
                        valueView,
                        key
                    )
                }
            }
        }
    }

    /**
     * 重试加载
     */
    private fun retryLoad(view: View, id: Int) {
        val retryView: View? = view.findViewById<View>(if (mStatusLayoutManager?.retryViewId !== 0) mStatusLayoutManager!!.retryViewId else id)
        if (retryView == null || mStatusLayoutManager?.onRetryListener == null) return
        retryView.setOnClickListener { mStatusLayoutManager?.onRetryListener?.onRetry() }
    }

    private fun inflateLayout(id: Int): Boolean {
        var isShow = true
        if (layoutSparseArray.get(id) != null) return isShow
        when (id) {
            LAYOUT_NETWORK_ERROR_ID -> if (mStatusLayoutManager?.netWorkErrorVs != null) {
                val view: View = mStatusLayoutManager?.netWorkErrorVs!!.inflate()
                retryLoad(view, mStatusLayoutManager?.netWorkErrorRetryViewId!!)
                layoutSparseArray.put(id, view)
                isShow = true
            } else {
                isShow = false
            }
            LAYOUT_ERROR_ID -> if (mStatusLayoutManager?.errorVs != null) {
                val view: View = mStatusLayoutManager?.errorVs!!.inflate()
                if (mStatusLayoutManager?.errorLayout != null) mStatusLayoutManager?.errorLayout!!.setView(view)
                retryLoad(view, mStatusLayoutManager?.errorRetryViewId!!)
                layoutSparseArray.put(id, view)
                isShow = true
            } else {
                isShow = false
            }
            LAYOUT_EMPTYDATA_ID -> if (mStatusLayoutManager?.emptyDataVs != null) {
                val view: View = mStatusLayoutManager?.emptyDataVs!!.inflate()
                if (mStatusLayoutManager?.emptyDataLayout != null) mStatusLayoutManager?.emptyDataLayout?.setView(view)
                retryLoad(view, mStatusLayoutManager?.emptyDataRetryViewId!!)
                layoutSparseArray.put(id, view)
                isShow = true
            } else {
                isShow = false
            }
        }
        return isShow
    }

    fun showLoading() {
        if (layoutSparseArray.get(LAYOUT_LOADING_ID) != null) {
            showHideViewById(LAYOUT_LOADING_ID)
        }
    }

    fun showContent() {
        if (layoutSparseArray.get(LAYOUT_CONTENT_ID) != null) {
            showHideViewById(LAYOUT_CONTENT_ID)
        }
    }

    //00
    fun showEmptyData(iconImage: Int, textTip: String) {
        if (inflateLayout(LAYOUT_EMPTYDATA_ID)) {
            showHideViewById(LAYOUT_EMPTYDATA_ID)
            emptyDataViewAddData(iconImage, textTip)
        }
    }

    private fun emptyDataViewAddData(iconImage: Int, textTip: String) {
        if (iconImage == 0 && TextUtils.isEmpty(textTip)) return
        val emptyDataView: View = layoutSparseArray.get(LAYOUT_EMPTYDATA_ID)
        val iconImageView: View = emptyDataView.findViewById<View>(mStatusLayoutManager?.emptyDataIconImageId!!)
        val textView: View = emptyDataView.findViewById<View>(mStatusLayoutManager?.emptyDataTextTipId!!)
        if (iconImageView is ImageView) {
            iconImageView.setImageResource(iconImage)
        }

        if (textView is TextView) {
            textView.text = textTip
        }
    }

    fun showLayoutEmptyData(vararg any: Any) {
        if (inflateLayout(LAYOUT_EMPTYDATA_ID)) {
            showHideViewById(LAYOUT_EMPTYDATA_ID)
            val emptyDataLayout: AbsLayout? = mStatusLayoutManager?.emptyDataLayout
            emptyDataLayout?.setData(*any)
        }
    }

    /**
     * 显示网络异常
     */
    fun showNetWorkError() {
        if (inflateLayout(LAYOUT_NETWORK_ERROR_ID)) {
            showHideViewById(LAYOUT_NETWORK_ERROR_ID)
        }
    }

    /**
     * 显示异常
     */
    fun showError(iconImage: Int, textTip: String) {
        if (inflateLayout(LAYOUT_ERROR_ID)) {
            showHideViewById(LAYOUT_ERROR_ID)
            errorViewAddData(iconImage, textTip)
        }
    }

    private fun errorViewAddData(iconImage: Int, textTip: String) {
        if (iconImage == 0 && TextUtils.isEmpty(textTip)) return
        val errorView: View = layoutSparseArray.get(LAYOUT_ERROR_ID)
        val iconImageView: View = errorView.findViewById<View>(mStatusLayoutManager?.emptyDataIconImageId!!)
        val textView: View = errorView.findViewById<View>(mStatusLayoutManager?.emptyDataTextTipId!!)
        if (iconImageView is ImageView) {
            iconImageView.setImageResource(iconImage)
        }

        if (textView is TextView) {
            textView.text = textTip
        }
    }

    fun showLayoutError(vararg objects: Any) {
        if (inflateLayout(LAYOUT_ERROR_ID)) {
            showHideViewById(LAYOUT_ERROR_ID)
            val errorLayout: AbsLayout? = mStatusLayoutManager?.errorLayout
            errorLayout?.setData(*objects)
        }
    }
}