package com.maple.demo.kotlinmvvm.app.ex

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.maple.demo.kotlinmvvm.BR

/**
 * author: gaogq
 * time: 2019/4/15 13:05
 * description:
 */
abstract class BaseActivity<DB:ViewDataBinding>:AppCompatActivity() {
    abstract fun layoutResID():Int
    abstract fun initCreate(savedInstanceState: Bundle?)

    protected val binding: DB by lazy { initBinding() }

    protected fun initBinding() = DataBindingUtil.setContentView<DB>(this, layoutResID())





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // binding.setVariable(BR.viewModel, viewModel)
        binding.setLifecycleOwner(this)
        initCreate(savedInstanceState)
    }

}