package com.maple.demo.kotlinmvvm.app.base

import android.os.Bundle
import android.support.annotation.ColorRes
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

    var loadingDialog:LoadingDialog? = null

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
        if(useTransStateBar()){
            setTransStateBar()
        }
        initCreate(savedInstanceState)
    }

    private fun setTransStateBar(){
        ImmersionBar.with(this)
                .transparentStatusBar()
                .navigationBarColor(R.color.transparent)
                .navigationBarDarkIcon(true)
                .init()
    }

    open fun setToolBarColor(@ColorRes resId:Int = R.color.toolbar){
        ImmersionBar.with(this)
                .barColor(resId)
                .navigationBarColor(R.color.transparent)
                .navigationBarDarkIcon(true)
                .init()
    }


     fun showLoading(smg:String = UIUtils.getString(R.string.msg_loading)){
        if(loadingDialog == null){
            loadingDialog = LoadingDialog(this,smg)
        }
        if(!loadingDialog!!.isShowing){
            loadingDialog!!.show()
        }
    }

     fun hideLoading(){
        if(loadingDialog != null && loadingDialog!!.isShowing){
            loadingDialog!!.cancel()
        }
    }
}