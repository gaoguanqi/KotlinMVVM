package com.maple.demo.kotlinmvvm.app.base

import android.os.Bundle

/**
 * author: gaogq
 * time: 2019/3/27 18:19
 * description:
 */
abstract class BaseViewActivity : BaseActivity(){

    override fun onContentView() {
        val layoutId:Int = layoutResID()
        if(layoutId != 0){
            setContentView(layoutId)
        }
    }

    override fun initCreate(savedInstanceState: Bundle?) {

    }
}