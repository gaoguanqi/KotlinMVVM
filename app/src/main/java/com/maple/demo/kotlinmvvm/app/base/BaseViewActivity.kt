package com.maple.demo.kotlinmvvm.app.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.Toolbar
import android.widget.LinearLayout
import com.maple.demo.kotlinmvvm.R
import com.maple.statuslayout.status.OnRetryListener
import com.maple.statuslayout.status.StatusLayoutManager
import kotlinx.android.synthetic.main.layout_toolbar.*

/**
 * author: gaogq
 * time: 2019/3/27 18:19
 * description:
 */
abstract class BaseViewActivity<DB : ViewDataBinding, VM : BaseViewModel> : BaseActivity(), IView {

    lateinit var binding: DB
    abstract fun getBindingVariable(): Int
    abstract fun getViewModel(): VM
    protected var mStatusLayoutManager: StatusLayoutManager? = null

    override fun onContentView() {
        binding = DataBindingUtil.setContentView(this, R.layout.layout_base)
        binding.executePendingBindings()
        binding.setVariable(getBindingVariable(), getViewModel())
        initStatusLayout()
        initToolbar(toolbar)
    }

    private fun initStatusLayout() {
        if(layoutResID() != 0) {
            mStatusLayoutManager = StatusLayoutManager.newBuilder(this)
                    .contentView(layoutResID())
                    .emptyDataView(R.layout.layout_empty_view)
                    .emptyDataRetryViewId(R.id.tv_click_empty)
                    .errorView(R.layout.layout_error_view)
                    .errorRetryViewId(R.id.tv_click_error)
                    .netWorkErrorView(R.layout.layout_no_network_view)
                    .netWorkErrorRetryViewId(R.id.tv_click_no_network)
                    .loadingView(R.layout.layout_loading_view)
                    .onRetryListener(object : OnRetryListener {
                        override fun onRetry() {
                            mStatusLayoutManager?.showLoading()
                            onStatusViewRetry()
                        }
                    })
                    .build()
            val rootLayout:LinearLayout = findViewById<LinearLayout>(R.id.root_base)
            rootLayout.addView(mStatusLayoutManager?.getRootLayout())
        }
    }

    /**
     * 错误页和空页面点击重试
     */
    open fun onStatusViewRetry() {

    }


    open fun initToolbar(toolbar: Toolbar?) {
        if (toolbar == null) {
            return
        }
        setSupportActionBar(toolbar)
        getSupportActionBar()?.setDisplayShowTitleEnabled(false)
    }
}