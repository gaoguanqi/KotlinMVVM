package com.maple.demo.kotlinmvvm.utils

import android.support.annotation.StringRes
import android.text.TextUtils
import android.widget.Toast
import com.blankj.utilcode.util.Utils
import com.maple.demo.kotlinmvvm.app.MyApplication
import es.dmoral.toasty.Toasty

/**
 * author: gaogq
 * time: 2019/3/28 18:04
 * description:
 */
class ToastUtil {
    companion object {
        fun showToast(text:String?){
            if(!TextUtils.isEmpty(text))show(text!!)
        }

        fun showToast(@StringRes resId:Int){
            val text:String = UIUtils.getString(resId)
            if(!TextUtils.isEmpty(text)) show(text)
        }

        private fun show(text:String){
            Toasty.info(MyApplication.instance, text, Toast.LENGTH_SHORT, false).show();
        }
    }
}