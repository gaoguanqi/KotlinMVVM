package com.maple.statuslayout.status

import android.content.Context
import android.support.annotation.LayoutRes
import android.view.View
import android.view.ViewStub



/**
 * author: gaogq
 * time: 2019/5/17 11:19
 * description:
 */
abstract class AbsLayout {
     lateinit var mLayoutVs: ViewStub
     lateinit var mContentView: View

     fun initLayout(@LayoutRes layoutResId:Int,context:Context){
        mLayoutVs = ViewStub(context)
        mLayoutVs.layoutResource = layoutResId
    }

     fun getLayoutVs():ViewStub = mLayoutVs

     fun setView(contentView:View){
        mContentView = contentView
    }

    abstract fun setData(vararg any: Any)
}