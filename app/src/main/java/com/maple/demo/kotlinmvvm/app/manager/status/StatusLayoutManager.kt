package com.maple.statuslayout.status

import android.content.Context
import android.support.annotation.LayoutRes
import android.view.View
import android.view.ViewGroup
import android.view.ViewStub
import com.maple.demo.kotlinmvvm.R


/**
 * author: gaogq
 * time: 2019/5/17 11:44
 * description:
 */
class StatusLayoutManager {
    var context: Context? = null
    var netWorkErrorVs: ViewStub? = null
    var netWorkErrorRetryViewId: Int = 0
    var emptyDataVs: ViewStub? = null
    var emptyDataRetryViewId: Int = 0
    var errorVs: ViewStub? = null
    var errorRetryViewId: Int = 0
    var loadingLayoutResId: Int = 0
    var contentLayoutResId: Int = 0
    var retryViewId: Int = 0
    var emptyDataIconImageId: Int = 0
    var emptyDataTextTipId: Int = 0
    var errorIconImageId: Int = 0
    var errorTextTipId: Int = 0
    var errorLayout: AbsLayout? = null
    var emptyDataLayout: AbsLayout? = null

    var rootFrameLayout: RootFrameLayout? = null
    var onShowHideViewListener: OnShowHideViewListener? = null
    var onRetryListener: OnRetryListener? = null

    constructor(builder: Builder) {
        this.context = builder.context
        this.loadingLayoutResId = builder.loadingLayoutResId
        this.netWorkErrorVs = builder.netWorkErrorVs
        this.netWorkErrorRetryViewId = builder.netWorkErrorRetryViewId
        this.emptyDataVs = builder.emptyDataVs
        this.emptyDataRetryViewId = builder.emptyDataRetryViewId
        this.errorVs = builder.errorVs
        this.errorRetryViewId = builder.errorRetryViewId
        this.contentLayoutResId = builder.contentLayoutResId
        this.onShowHideViewListener = builder.onShowHideViewListener
        this.retryViewId = builder.retryViewId
        this.onRetryListener = builder.onRetryListener
        this.emptyDataIconImageId = builder.emptyDataIconImageId
        this.emptyDataTextTipId = builder.emptyDataTextTipId
        this.errorIconImageId = builder.errorIconImageId
        this.errorTextTipId = builder.errorTextTipId
        this.errorLayout = builder.errorLayout
        this.emptyDataLayout = builder.emptyDataLayout

        this.rootFrameLayout = RootFrameLayout(this.context)
        this.rootFrameLayout?.layoutParams =
            ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
            this.rootFrameLayout?.setStatusLayoutManager(this)

    }


    /**
     * 显示loading
     */
    fun showLoading() {
        rootFrameLayout?.showLoading()
    }

    /**
     * 显示内容
     */
    fun showContent() {
        rootFrameLayout?.showContent()
    }

    /**
     * 显示空数据
     */
    fun showEmptyData(iconImage: Int = R.mipmap.ic_launcher, textTip: String = "显示空") {
        rootFrameLayout?.showEmptyData(iconImage, textTip)
    }

    fun showLayoutEmptyData(vararg any: Any) {
        rootFrameLayout?.showLayoutEmptyData(any)
    }

    /**
     * 显示网络异常
     */
    fun showNetWorkError() {
        rootFrameLayout?.showNetWorkError()
    }

    /**
     * 显示异常
     */
    fun showError(iconImage: Int = R.mipmap.ic_launcher, textTip: String = "显示异常") {
        rootFrameLayout?.showError(iconImage, textTip)
    }


    fun showLayoutError(vararg objects: Any) {
        rootFrameLayout?.showLayoutError(objects)
    }

    /**
     * 得到root 布局
     */
    fun getRootLayout(): View? {
        return rootFrameLayout
    }


    class Builder {
        var context: Context
        var loadingLayoutResId: Int = 0
        var contentLayoutResId: Int = 0
        var netWorkErrorVs: ViewStub? = null
        var netWorkErrorRetryViewId: Int = 0
        var emptyDataVs: ViewStub? = null
        var emptyDataRetryViewId: Int = 0
        var errorVs: ViewStub? = null
        var errorRetryViewId: Int = 0
        var retryViewId: Int = 0
        var emptyDataIconImageId: Int = 0
        var emptyDataTextTipId: Int = 0
        var errorIconImageId: Int = 0
        var errorTextTipId: Int = 0
        var errorLayout: AbsLayout? = null
        var emptyDataLayout: AbsLayout? = null
        var onShowHideViewListener: OnShowHideViewListener? = null
        var onRetryListener: OnRetryListener? = null

        constructor(context: Context) {
            this.context = context
        }

        fun loadingView(@LayoutRes loadingLayoutResId: Int): Builder {
            this.loadingLayoutResId = loadingLayoutResId
            return this
        }

        fun contentView(@LayoutRes contentLayoutResId: Int): Builder {
            this.contentLayoutResId = contentLayoutResId
            return this
        }

        fun netWorkErrorView(@LayoutRes newWorkErrorId: Int): Builder {
            this.netWorkErrorVs = ViewStub(context)
            this.netWorkErrorVs?.layoutResource = newWorkErrorId
            return this
        }

        fun emptyDataView(@LayoutRes noDataViewId: Int): Builder {
            this.emptyDataVs = ViewStub(context)
            this.emptyDataVs?.layoutResource = noDataViewId
            return this
        }

        fun errorView(@LayoutRes errorViewId: Int): Builder {
            this.errorVs = ViewStub(context)
            this.errorVs?.layoutResource = errorViewId
            return this
        }

        fun netWorkErrorRetryViewId(netWorkErrorRetryViewId: Int): Builder {
            this.netWorkErrorRetryViewId = netWorkErrorRetryViewId
            return this
        }

        fun emptyDataRetryViewId(emptyDataRetryViewId: Int): Builder {
            this.emptyDataRetryViewId = emptyDataRetryViewId
            return this
        }

        fun errorRetryViewId(errorRetryViewId: Int): Builder {
            this.errorRetryViewId = errorRetryViewId
            return this
        }

        fun retryViewId(retryViewId: Int): Builder {
            this.retryViewId = retryViewId
            return this
        }

        fun emptyDataIconImageId(emptyDataIconImageId: Int): Builder {
            this.emptyDataIconImageId = emptyDataIconImageId
            return this
        }

        fun emptyDataTextTipId(emptyDataTextTipId: Int): Builder {
            this.emptyDataTextTipId = emptyDataTextTipId
            return this
        }

        fun errorIconImageId(errorIconImageId: Int): Builder {
            this.errorIconImageId = errorIconImageId
            return this
        }

        fun errorTextTipId(errorTextTipId: Int): Builder {
            this.errorTextTipId = errorTextTipId
            return this
        }

        fun errorLayout(errorLayout: AbsLayout): Builder {
            this.errorLayout = errorLayout
            return this
        }

        fun emptyDataLayout(emptyDataLayout: AbsLayout): Builder {
            this.emptyDataLayout = emptyDataLayout
            return this
        }

        fun onShowHideViewListener(onShowHideViewListener: OnShowHideViewListener): Builder {
            this.onShowHideViewListener = onShowHideViewListener
            return this
        }

        fun onRetryListener(onRetryListener: OnRetryListener): Builder {
            this.onRetryListener = onRetryListener
            return this
        }

        fun build(): StatusLayoutManager {
            return StatusLayoutManager(this)
        }
    }

    companion object {
        fun newBuilder(context: Context): Builder {
            return Builder(context)
        }
    }
}