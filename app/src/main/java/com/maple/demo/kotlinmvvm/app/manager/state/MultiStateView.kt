package com.maple.demo.kotlinmvvm.app.manager.state

import android.content.Context
import android.content.res.TypedArray
import android.graphics.drawable.Drawable
import android.support.annotation.LayoutRes
import android.text.TextUtils
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import com.maple.demo.kotlinmvvm.R
import com.maple.demo.kotlinmvvm.utils.LogUtils


/**
 * author: gaogq
 * time: 2019/4/4 10:59
 * description:
 */
class MultiStateView : FrameLayout {

    private val STATE_LOADING: Int = 2
    private val STATE_SUCCESS: Int = 1
    private val STATE_EMPTY: Int = 0
    private val STATE_NET_ERROR: Int = -1
    private val STATE_UNKNOWN: Int = -2
    private val STATE_NEW_STATE: Int = -3

    //四种状态默认的viewid
    private var mLoadingViewId: Int = 0
    private var mSuccessViewId: Int = 0
    private var mEmptyViewId: Int = 0
    private var mUnKnownViewId: Int = 0
    private var mNetErrorViewId: Int = 0

    private var mEmptyDrawable: Drawable? = null
    private var mEmptyDesc: String? = null

    //四种展示的view
    private var mLoadingView: View? = null
    private var mSuccessView: View? = null
    private var mNetErrorView: View? = null
    private var mEmptyView: View? = null
    private var mUnKnownView: View? = null
    private var newStateView: View? = null//这是新的状态页面

    private lateinit var mInflater: LayoutInflater
    private lateinit var params: ViewGroup.LayoutParams
    private var mOnReLodListener: OnReLodListener? = null//重新加载的监听
    private var currentState: Int = 0

    private var mContext: Context

    constructor (context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        this.mContext = context
        initView(context, attrs, defStyleAttr)
    }

    private fun initView(context: Context, attrs: AttributeSet?, defStyleAttr: Int) {
        val array: TypedArray = context.obtainStyledAttributes(attrs, R.styleable.MultiStateView)

        mLoadingViewId = array.getResourceId(R.styleable.MultiStateView_msv_loadingView, R.layout.layout_loading_view)
        mSuccessViewId = array.getResourceId(R.styleable.MultiStateView_msv_successView, 0)
        mEmptyViewId = array.getResourceId(R.styleable.MultiStateView_msv_emptyView, R.layout.layout_empty_view)
        mEmptyDrawable = array.getDrawable(R.styleable.MultiStateView_msv_emptyViewImage)
        mEmptyDesc = array.getString(R.styleable.MultiStateView_msv_emptyViewText)
        mUnKnownViewId = array.getResourceId(R.styleable.MultiStateView_msv_unknownView, R.layout.layout_error_view)
        mNetErrorViewId = array.getResourceId(R.styleable.MultiStateView_msv_netErrorView, R.layout.layout_no_network_view)

        array.recycle()
        mInflater = LayoutInflater.from(context)
        params = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
    }

    override fun onFinishInflate() {
        super.onFinishInflate()
        showLoading()
    }
//++++++++++++++++++++++++++++++++加载页面+++++++++++++++++++

    /**
     * 显示加载中的状态
     */
    fun showLoading() {
        if (mLoadingView == null) {
            mLoadingView = mInflater.inflate(mLoadingViewId, null)
        }
        if (mLoadingView != null && currentState != STATE_LOADING) {
            removeAllViews()
            addView(mLoadingView, 0, params)
            currentState = STATE_LOADING
        } else {
            throw NullPointerException("you have to set loading view before that")
        }
    }


    fun setLoadingView(@LayoutRes layoutResID: Int) {
        setLoadingView(mInflater.inflate(layoutResID, null))
    }


    fun setLoadingView(view: View) {
        mLoadingView = view
    }

    fun getLoadingView(): View {
        if (mLoadingView == null) {
            mLoadingView = mInflater.inflate(mLoadingViewId, null)
        }
        return mLoadingView!!
    }

//++++++++++++++++++++++++++++++++成功页面++++++++++++++++++++

    /**
     * 显示成功状态
     */
    fun showSuccess() {
        if (mSuccessView == null) {
            mSuccessView = mInflater.inflate(mSuccessViewId, null)
        }
        if (mSuccessView != null && currentState != STATE_SUCCESS) {
            removeAllViews()
            addView(mSuccessView, 0, params)
            currentState = STATE_SUCCESS
        } else {
            throw NullPointerException("you have to set success view before that")
        }
    }

    fun setSuccessView(@LayoutRes layoutResID: Int) {
        setSuccessView(mInflater.inflate(layoutResID, null))
    }

    fun setSuccessView(view: View) {
        mSuccessView = view
    }

    fun getSuccessView(): View {
        if (mSuccessView == null) {
            mSuccessView = mInflater.inflate(mSuccessViewId, null)
        }
        return mSuccessView!!
    }

    //++++++++++++++++++++++++++++++++未知错误页面++++++++++++++++++++

    fun showUnKnown() {
        if (mUnKnownView == null) {
            mUnKnownView = mInflater.inflate(mUnKnownViewId, null)
        }
        if (mUnKnownView != null && currentState != STATE_UNKNOWN) {
            removeAllViews()
            addView(mUnKnownView, 0, params)
            currentState = STATE_UNKNOWN
        } else {
            throw NullPointerException("you have to set unknown view before that")
        }
    }

    fun setUnKnownView(@LayoutRes layoutResID: Int) {
        setUnKnownView(mInflater.inflate(layoutResID, null))
    }

    fun setUnKnownView(view: View) {
        mUnKnownView = view
    }

    fun getUnKnownView(): View {
        if (mUnKnownView == null) {
            mUnKnownView = mInflater.inflate(mUnKnownViewId, null)
        }
        return mUnKnownView!!
    }

    //++++++++++++++++++++++++++++++++网络错误页面++++++++++++++++++++

    fun showNetError() {
        if (mNetErrorView == null) {
            mNetErrorView = mInflater.inflate(mNetErrorViewId, null)
        }

        if (mNetErrorView != null && currentState != STATE_NET_ERROR) {
            removeAllViews()
            addView(mNetErrorView, 0, params)
            currentState = STATE_NET_ERROR
            mNetErrorView?.setOnClickListener {
                showReLoading()
            }
        } else {
            throw NullPointerException("you have to set unknown view before that")
        }
    }

    /**
     * 设置自定义的网络异常
     */

    fun setNetErrorView(@LayoutRes layoutResID: Int) {
        setNetErrorView(mInflater.inflate(layoutResID, null))
    }

    fun setNetErrorView(view: View) {
        mNetErrorView = view
    }

    fun getNetErrorView(): View {
        if (mNetErrorView == null) {
            mNetErrorView = mInflater.inflate(mNetErrorViewId, null)
        }
        return mNetErrorView!!
    }


    //++++++++++++++++++++++++++++++++空页面页面++++++++++++++++++++

    fun showEmpty() {
        if (mEmptyView == null) {
            mEmptyView = mInflater.inflate(mEmptyViewId, null)
        }
        if (mEmptyView != null && currentState != STATE_EMPTY) {
            removeAllViews()
            handleDiffEmpty()
            addView(mEmptyView, 0, params)
            currentState = STATE_EMPTY
        } else {
            throw NullPointerException("you have to set empty view before that")
        }
    }

    fun handleDiffEmpty() {
        if (mEmptyView is ViewGroup) {
            val mEmptyViews: ViewGroup = mEmptyView as ViewGroup
            val emptyImage: ImageView? = mEmptyViews.getChildAt(0) as ImageView
            val emptyDesc: TextView? = mEmptyViews.getChildAt(1) as TextView
            if (emptyImage != null && mEmptyDrawable != null) {
                emptyImage.setImageDrawable(mEmptyDrawable)
            }
            if (emptyDesc != null && TextUtils.isEmpty(mEmptyDesc)) {
                emptyDesc.setText(mEmptyDesc)
            }
        }
    }

    /**
     * 设置自定义的空页面
     */
    fun setEmptyView(@LayoutRes layoutResID: Int) {
        setEmptyView(mInflater.inflate(layoutResID, null))
    }

    fun setEmptyView(view: View) {
        mEmptyView = view
    }

    fun getEmptyView(): View {
        if (mEmptyView == null) {
            mEmptyView = mInflater.inflate(mEmptyViewId, null)
        }
        return mEmptyView!!
    }

    /**
     * 设置自定义的新增状态页面空页面
     */
    fun setNewStateView(@LayoutRes layoutResID: Int) {
        setNewStateView(mInflater.inflate(layoutResID, null))
    }

    fun setNewStateView(view: View) {
        newStateView = view
    }

    /**
     * 显示新状态view
     */
    fun showNewStateView() {
        if (newStateView != null && currentState != STATE_NEW_STATE) {
            removeAllViews()
            addView(newStateView, 0, params)
            currentState = STATE_NEW_STATE
        } else {
            throw  NullPointerException("you set new state view is null")
        }
    }

    fun getNewStateView(): View? {
        return newStateView
    }

    /**
     * 再次加载数据
     */

    fun showReLoading() {
        //第一步重新loading
        if (mOnReLodListener != null) {
            showLoading()
            mOnReLodListener?.onReLoad()
        } else {
            //未设置重新加载回调
            LogUtils.logGGQ("未设置重新加载回调")
        }
    }

    fun setOnReLodListener(onReLodListener: OnReLodListener?) {
        this.mOnReLodListener = onReLodListener
    }

    interface OnReLodListener {
        fun onReLoad()
    }
}