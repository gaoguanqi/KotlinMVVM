package com.maple.demo.kotlinmvvm.utils

import android.text.TextUtils
import android.util.Log

/**
 * author: gaogq
 * time: 2019/4/4 13:49
 * description:
 */
class LogUtils {
    companion object {
        fun logGGQ(msg:String?){
            if(!TextUtils.isEmpty(msg)){
                Log.i("GGQ", msg)
            }
        }
    }
}