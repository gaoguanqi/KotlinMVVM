package com.maple.demo.kotlinmvvm.app.base

import android.os.Bundle

/**
 * author: gaogq
 * time: 2019/3/27 18:19
 * description:
 */
abstract class BaseViewActivity : BaseActivity(){
    override fun onContentView() {
       setContentView(layoutResID())
    }

    override fun initCreate(savedInstanceState: Bundle?) {

    }
}