package com.maple.demo.kotlinmvvm.app.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle

/**
 * author: gaogq
 * time: 2019/3/27 18:19
 * description:
 */
abstract class BaseViewActivity<B : ViewDataBinding> : BaseActivity(){
    lateinit var binding: B
    override fun onContentView() {
        binding = DataBindingUtil.setContentView(this, layoutResID())
    }

    override fun initCreate(savedInstanceState: Bundle?) {

    }

    override fun onDestroy() {
        super.onDestroy()
        binding.unbind()
    }
}