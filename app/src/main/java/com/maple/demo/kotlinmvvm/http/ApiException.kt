package com.maple.demo.kotlinmvvm.http

import java.lang.RuntimeException

/**
 * author: gaogq
 * time: 2019/4/16 9:11
 * description:
 */
class ApiException(var code:Int ,override var message :String?):RuntimeException(message) {
    fun code():Int {
        return code
    }

    fun message():String?{
        return  message
    }
}