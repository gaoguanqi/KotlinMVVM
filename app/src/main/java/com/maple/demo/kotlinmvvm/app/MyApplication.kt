package com.maple.demo.kotlinmvvm.app

import android.app.Application
import com.blankj.utilcode.util.Utils
import com.maple.demo.kotlinmvvm.BuildConfig
import es.dmoral.toasty.Toasty
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.orhanobut.logger.Logger.addLogAdapter



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
        Toasty.Config.getInstance().setTextSize(14).apply()
        Logger.addLogAdapter(object :AndroidLogAdapter(){
            override fun isLoggable(priority: Int, tag: String?): Boolean {
                return BuildConfig.DEBUG
            }
        })

    }
}