package com.maple.demo.kotlinmvvm.test

import android.os.Bundle
import com.maple.demo.kotlinmvvm.R
import com.maple.demo.kotlinmvvm.app.base.BaseActivity

class TestActivity : BaseActivity() {
    override fun layoutResID(): Int = R.layout.activity_test

    override fun initCreate(savedInstanceState: Bundle?) {
    }
}
