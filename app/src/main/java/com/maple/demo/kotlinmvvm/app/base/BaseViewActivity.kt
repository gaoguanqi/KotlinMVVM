package com.maple.demo.kotlinmvvm.app.base

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v4.app.FragmentActivity
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
abstract class BaseViewActivity<DB: ViewDataBinding,VM:BaseViewModel> : BaseDBActivity<DB>(),IView{

    lateinit var viewModel:VM


    override fun onContentView() {
        binding = DataBindingUtil.setContentView(this,R.layout.layout_base)
        initMultipleStatusView(multiple_status_view)
        ViewModelProviders.of(this).get(viewModel::class.java);
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


    fun  <T:BaseViewModel>createViewModel(activity:FragmentActivity,cls:Class<T>):T = ViewModelProviders.of(activity).get(cls)


}