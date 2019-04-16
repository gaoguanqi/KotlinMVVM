package com.maple.demo.kotlinmvvm.app.base

import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.ViewModel
import com.maple.demo.kotlinmvvm.app.MyApplication
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * author: gaogq
 * time: 2019/3/28 17:52
 * description:
 */
abstract class BaseViewModel(app:MyApplication) : AndroidViewModel(app) {

    var compositeDisposable: CompositeDisposable? = null

    fun addDisposable(disposable: Disposable){
        if(compositeDisposable == null || compositeDisposable!!.isDisposed){
            compositeDisposable = CompositeDisposable()
        }
        compositeDisposable?.add(disposable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable?.dispose()
        compositeDisposable = null
    }
}