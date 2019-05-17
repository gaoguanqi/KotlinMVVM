package com.maple.demo.kotlinmvvm.app.manager.status.layout

import android.content.Context
import android.widget.TextView
import com.maple.demo.kotlinmvvm.R
import com.maple.statuslayout.status.AbsLayout

/**
 * author: gaogq
 * time: 2019/5/17 14:25
 * description:
 */
class EmptyLayout: AbsLayout {

    constructor(context:Context){
        initLayout(R.layout.layout_empty_view,context)
    }
    override fun setData(vararg any: Any) {
        val tvStatus:TextView = mContentView.findViewById<TextView>(R.id.tv_status_empty)
        tvStatus.setText(any.toString())
    }
}