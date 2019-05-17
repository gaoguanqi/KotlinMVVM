package com.maple.statuslayout.status

import android.view.View

/**
 * author: gaogq
 * time: 2019/5/17 11:30
 * description:
 */
interface OnShowHideViewListener {
    fun onShowView(view: View, id:Int)
    fun onHideView(view: View, id:Int)
}