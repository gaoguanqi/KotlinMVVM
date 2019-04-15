package com.maple.demo.kotlinmvvm.utils

import android.text.TextUtils
import android.util.Log
import com.maple.demo.kotlinmvvm.BuildConfig

/**
 * author: gaogq
 * time: 2019/4/4 13:49
 * description:
 */
class LogUtils {
    companion object {
        @JvmStatic
        fun logGGQ(msg:String?){
            if(BuildConfig.DEBUG){
                Log.i("GGQ", msg)
            }
        }
    }
}