package com.maple.demo.kotlinmvvm.app

import android.app.Application
import com.blankj.utilcode.util.Utils
import es.dmoral.toasty.Toasty
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers


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
        initConfig(this)
    }

    /**
     * App 启动时，Application 需要初始化一些配置信息，比如第三方sdk、第三方库等。
     * 此时，我会给每一个需要初始化的配置单独使用一个线程来处理，然后使用 merge 操作符进行合并。
     */
    private fun initConfig(app: MyApplication) {
        val initUtilsObservable = Observable.create<Any> {
            Utils.init(app)
        }.subscribeOn(Schedulers.newThread())

        val initToastyObservable = Observable.create<Any> {
            Toasty.Config.getInstance().setTextSize(14).apply()
        }.subscribeOn(Schedulers.newThread())

        Observable.mergeArray(initUtilsObservable, initToastyObservable).subscribe()
    }

//    private fun initConfig(app: MyApplication) {
//        Utils.init(app)
//        Toasty.Config.getInstance().setTextSize(14).apply()
//    }
}