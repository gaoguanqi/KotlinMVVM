package com.maple.demo.kotlinmvvm.app.base

import android.arch.lifecycle.AndroidViewModel
import com.maple.demo.kotlinmvvm.app.MyApplication

/**
 * author: gaogq
 * time: 2019/3/28 17:52
 * description:
 */
open class BaseViewModel<T:BaseRepository>(application: MyApplication) : AndroidViewModel(application) {

    lateinit var mRepository:T

    init {

    }


}