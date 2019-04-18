package com.maple.demo.kotlinmvvm.app.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
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
abstract class BaseViewActivity<DB: ViewDataBinding,VM:BaseViewModel> : BaseActivity(),IView{

    lateinit var binding:DB

     abstract fun getBindingVariable(): Int
     abstract fun getViewModel():VM

    override fun onContentView() {
        binding = DataBindingUtil.setContentView(this,R.layout.layout_base)
        binding.executePendingBindings()
        binding.setVariable(getBindingVariable(), getViewModel())
        initMultipleStatusView(multiple_status_view)
        initToolbar(toolbar)
    }

     fun initMultipleStatusView(multipleStatusView: MultipleStatusView?){
        if(multipleStatusView == null){
            return
        }
       // this. mMultipleStatusView = multipleStatusView
         multipleStatusView.setSuccessView(layoutResID())
         multipleStatusView.showEmpty()
    }

    open fun initToolbar(toolbar: Toolbar?){
        if(toolbar == null){
            return
        }
        setSupportActionBar(toolbar)
        getSupportActionBar()?.setDisplayShowTitleEnabled(false)
    }
}