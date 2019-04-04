package com.maple.demo.kotlinmvvm.test

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.maple.demo.kotlinmvvm.R
import kotlinx.android.synthetic.main.layout_toolbar.*

class TestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)


        setSupportActionBar(toolbar)
        getSupportActionBar()?.setDisplayShowTitleEnabled(false)
    }
}
