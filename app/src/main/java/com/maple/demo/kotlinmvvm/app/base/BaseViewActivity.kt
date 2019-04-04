package com.maple.demo.kotlinmvvm.app.base

import android.os.Bundle
import android.support.v7.widget.Toolbar
import com.maple.demo.kotlinmvvm.R
import com.maple.demo.kotlinmvvm.app.manager.state.MultipleStatusView
import kotlinx.android.synthetic.main.layout_base.*
import kotlinx.android.synthetic.main.layout_toolbar.*

/**
 * author: gaogq
 * time: 2019/3/27 18:19
 * description:
 */
abstract class BaseViewActivity : BaseActivity(){
    override fun onContentView() {
       setContentView(R.layout.layout_base)
        initToolbar(toolbar)
        initMultipleStatusView(multiple_status_view)
    }

    open fun initMultipleStatusView(multipleStatusView: MultipleStatusView?){
        if(multipleStatusView == null){
            return
        }
        multipleStatusView.setSuccessView(layoutResID())
    }

    open fun initToolbar(toolbar: Toolbar?){
        if(toolbar == null){
            return
        }
        setSupportActionBar(toolbar)
        getSupportActionBar()?.setDisplayShowTitleEnabled(false)
    }

    override fun initCreate(savedInstanceState: Bundle?) {

    }
}