package com.maple.demo.kotlinmvvm.view.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.maple.demo.kotlinmvvm.app.base.BaseFragment

/**
 * author: gaogq
 * time: 2019/4/1 14:47
 * description:
 */
class WeclomePagerAdapter : FragmentPagerAdapter{

    lateinit var mList:ArrayList<BaseFragment>

    private constructor(fm: FragmentManager) : super(fm)

    constructor(fm: FragmentManager,list:ArrayList<BaseFragment>) : this(fm){
        this.mList = list
    }

    override fun getItem(position: Int): Fragment {
        return mList.get(position)
    }

    override fun getCount(): Int {
        return mList.size
    }

}