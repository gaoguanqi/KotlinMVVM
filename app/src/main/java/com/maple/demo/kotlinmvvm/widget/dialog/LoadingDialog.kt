package com.maple.demo.kotlinmvvm.widget.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import com.maple.demo.kotlinmvvm.R

/**
 * author: gaogq
 * time: 2019/4/2 15:42
 * description:
 */
class LoadingDialog(context: Context):Dialog(context){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_loading)
    }

}