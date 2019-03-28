package com.maple.demo.kotlinmvvm.widget.timer

import android.os.CountDownTimer

/**
 * author: gaogq
 * time: 2019/3/28 14:54
 * description:
 */
class MyCountDownTimer( millisInFuture:Long, countDownInterval:Long) : CountDownTimer(millisInFuture,countDownInterval) {
    var mCallback:OnTimerCallback? = null

    constructor(millisInFuture:Long, countDownInterval:Long,callback:OnTimerCallback) : this(millisInFuture,countDownInterval) {
        this.mCallback = callback
        mCallback?.onTimerStart()
    }

    override fun onTick(millis: Long) {
        mCallback?.onTimerTick(millis)
    }


    override fun onFinish() {
        mCallback?.onTimerEnd()
    }
}