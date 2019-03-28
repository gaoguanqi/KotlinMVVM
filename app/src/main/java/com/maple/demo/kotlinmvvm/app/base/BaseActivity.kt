package com.maple.demo.kotlinmvvm.app.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * author: gaogq
 * time: 2019/3/27 18:18
 * description:
 */
abstract class BaseActivity : AppCompatActivity() {

    abstract fun layoutResID():Int
    abstract fun initCreate(savedInstanceState: Bundle?)

    open fun onContentView(){
        setContentView(layoutResID())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onContentView();
        initCreate(savedInstanceState)
    }
}