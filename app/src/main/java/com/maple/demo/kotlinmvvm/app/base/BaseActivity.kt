package com.maple.demo.kotlinmvvm.app.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.gyf.barlibrary.ImmersionBar
import com.maple.demo.kotlinmvvm.R
import com.maple.demo.kotlinmvvm.utils.UIUtils
import com.maple.demo.kotlinmvvm.widget.dialog.LoadingDialog

/**
 * author: gaogq
 * time: 2019/3/27 18:18
 * description:
 */
abstract class BaseActivity : AppCompatActivity() {

    lateinit var loadingDialog:LoadingDialog

    abstract fun layoutResID():Int
    abstract fun initCreate(savedInstanceState: Bundle?)

    open fun useTransStateBar(): Boolean{
        return false
    }

    open fun onContentView(){
        setContentView(layoutResID())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onContentView();
        if(useTransStateBar())setTransStateBar()
        initCreate(savedInstanceState)
    }

    private fun setTransStateBar(){
        ImmersionBar.with(this)
                .transparentStatusBar()
                .navigationBarColor(R.color.transparent)
                .navigationBarDarkIcon(true)
                .init()
    }


    open fun showLoading(smg:String = UIUtils.getString(R.string.msg_loading)){
        loadingDialog = LoadingDialog(this,smg)
        if(!loadingDialog.isShowing){
            loadingDialog.show()
        }
    }

    open fun hideLoading(){
        if(loadingDialog != null && loadingDialog.isShowing){
            loadingDialog.cancel()
        }
    }
}