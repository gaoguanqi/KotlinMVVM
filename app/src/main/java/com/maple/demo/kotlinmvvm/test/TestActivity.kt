package com.maple.demo.kotlinmvvm.test

import android.os.Bundle
import com.maple.demo.kotlinmvvm.R
import com.maple.demo.kotlinmvvm.app.base.BaseViewActivity

class TestActivity : BaseViewActivity() {
    override fun layoutResID(): Int = R.layout.activity_test

    override fun initCreate(savedInstanceState: Bundle?) {
    }
}
