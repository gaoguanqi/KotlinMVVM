package com.maple.demo.kotlinmvvm.widget.refresh

import android.content.Context
import android.support.v4.widget.SwipeRefreshLayout
import android.util.AttributeSet

/**
 * author: gaogq
 * time: 2019/5/17 17:33
 * description:
 */
class MySwipeRefreshLayout : SwipeRefreshLayout{

    constructor(context: Context):super(context)
    constructor(context: Context,attrs: AttributeSet):super(context,attrs)

}