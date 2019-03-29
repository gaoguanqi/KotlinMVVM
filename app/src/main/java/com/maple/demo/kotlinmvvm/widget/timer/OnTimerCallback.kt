package com.maple.demo.kotlinmvvm.widget.timer

/**
 * author: gaogq
 * time: 2019/3/28 14:57
 * description:
 */
interface OnTimerCallback {
    fun onTimerStart()
    fun onTimerTick(s: String)
    fun onTimerEnd()
}