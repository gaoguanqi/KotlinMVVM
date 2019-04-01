package com.maple.demo.kotlinmvvm.utils

import android.support.annotation.StringRes
import android.widget.Toast
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
            text?.let { show(it) }
        }

        fun showToast(@StringRes resId:Int){
            UIUtils.getString(resId).also { show(it) }
        }

        private fun show(text:String){
            Toasty.info(MyApplication.instance, text, Toast.LENGTH_SHORT, false).show();
        }
    }
}