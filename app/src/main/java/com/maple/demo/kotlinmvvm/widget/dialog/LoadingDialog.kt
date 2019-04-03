package com.maple.demo.kotlinmvvm.widget.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import com.maple.demo.kotlinmvvm.R
import com.maple.demo.kotlinmvvm.utils.UIUtils
import kotlinx.android.synthetic.main.dialog_loading.*

/**
 * author: gaogq
 * time: 2019/4/2 15:42
 * description:
 */
class LoadingDialog(context: Context):Dialog(context){
    var msg:String = UIUtils.getString(R.string.msg_loading)

    constructor(context: Context,message:String):this(context){
        this.msg = message
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_loading)
        tv_msg.setText(msg)
    }

}