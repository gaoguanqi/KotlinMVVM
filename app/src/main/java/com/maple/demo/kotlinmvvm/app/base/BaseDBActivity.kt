package com.maple.demo.kotlinmvvm.app.base

import android.databinding.ViewDataBinding

/**
 * author: gaogq
 * time: 2019/4/15 11:52
 * description:
 */
abstract class BaseDBActivity<DB:ViewDataBinding>:BaseActivity() {

    lateinit var binding: DB




}