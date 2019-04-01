package com.maple.demo.kotlinmvvm.app.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * author: gaogq
 * time: 2019/3/29 11:30
 * description:
 */
abstract class BaseLazyFragment : BaseFragment(){

    override fun initView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return super.initView(inflater, container, savedInstanceState)
    }

}