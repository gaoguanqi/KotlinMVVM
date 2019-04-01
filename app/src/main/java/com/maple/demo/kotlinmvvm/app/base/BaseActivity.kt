package com.maple.demo.kotlinmvvm.app.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.gyf.barlibrary.ImmersionBar
import com.maple.demo.kotlinmvvm.R

/**
 * author: gaogq
 * time: 2019/3/27 18:18
 * description:
 */
abstract class BaseActivity : AppCompatActivity() {

    abstract fun layoutResID():Int
    abstract fun initCreate(savedInstanceState: Bundle?)

    open fun useTransStateBar(): Boolean{
        return false
    }

    open fun onContentView(){
        setContentView(layoutResID())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onContentView();
        if(useTransStateBar())setTransStateBar()
        initCreate(savedInstanceState)
    }

    private fun setTransStateBar(){
        ImmersionBar.with(this)
                .transparentStatusBar()
                .navigationBarColor(R.color.transparent)
                .navigationBarDarkIcon(true)
                .init()
    }
}