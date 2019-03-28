package com.maple.demo.kotlinmvvm.app

import android.app.Application
import com.blankj.utilcode.util.Utils

/**
 * author: gaogq
 * time: 2019/3/27 17:43
 * description:
 */
class MyApplication : Application(){

    companion object {
        @JvmStatic lateinit var instance:MyApplication
        private set
    }
    override fun onCreate() {
        super.onCreate()
        instance = this
        Utils.init(this)
    }
}