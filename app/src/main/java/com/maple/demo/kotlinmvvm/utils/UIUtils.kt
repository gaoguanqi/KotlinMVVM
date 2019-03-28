package com.maple.demo.kotlinmvvm.utils

import android.support.annotation.ColorRes
import android.support.annotation.StringRes
import com.blankj.utilcode.util.ColorUtils
import com.blankj.utilcode.util.StringUtils

/**
 * author: gaogq
 * time: 2019/3/28 18:28
 * description:
 */
class UIUtils {

    companion object {
        fun getString(@StringRes resId:Int): String {
            return StringUtils.getString(resId)
        }

        fun getColor(@ColorRes resId: Int) : Int{
            return ColorUtils.getColor(resId)
        }
    }
}