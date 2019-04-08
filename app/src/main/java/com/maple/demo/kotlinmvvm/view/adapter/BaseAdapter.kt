package com.maple.demo.kotlinmvvm.view.adapter

import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.maple.demo.kotlinmvvm.view.adapter.holder.BaseVH

/**
 * author: gaogq
 * time: 2019/4/8 11:08
 * description:
 */
abstract class BaseAdapter<Data, DB : ViewDataBinding>: RecyclerView.Adapter<BaseVH> {

    var layoutId:Int = 0
    var mData:MutableList<Data>? = null

    constructor(layoutId:Int){
        this.layoutId = layoutId
    }
    constructor(layoutId:Int,data: MutableList<Data>){
        this.layoutId = layoutId
        this.mData = data
    }


    override fun onCreateViewHolder(parent: ViewGroup, position: Int): BaseVH {
        val binding:DB  = DataBindingUtil.inflate(LayoutInflater.from(parent.context),layoutId,parent,false)
        return BaseVH(binding.root)
    }




}