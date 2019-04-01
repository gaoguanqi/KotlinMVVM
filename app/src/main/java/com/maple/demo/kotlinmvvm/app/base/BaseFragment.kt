package com.maple.demo.kotlinmvvm.app.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * author: gaogq
 * time: 2019/3/27 18:20
 * description:
 */
abstract class BaseFragment : Fragment(){
    abstract fun layoutResID():Int

    open fun initView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?):View {
        return inflater.inflate(layoutResID(),container,false)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //return super.onCreateView(inflater, container, savedInstanceState)
        return initView(inflater,container,savedInstanceState)
    }
}