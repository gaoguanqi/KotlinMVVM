package com.maple.demo.kotlinmvvm.view.activity

import android.os.Bundle
import com.maple.demo.kotlinmvvm.R
import com.maple.demo.kotlinmvvm.app.base.BaseActivity
import kotlinx.android.synthetic.main.activity_login.*

/**
 * author: gaogq
 * time: 2019/4/3 13:15
 * description:
 */
class LoginActivity : BaseActivity() {
    override fun layoutResID(): Int = R.layout.activity_login

    override fun initCreate(savedInstanceState: Bundle?) {
        btn_login.setOnClickListener{

        }
    }

    override fun onContentView() {
        super.onContentView()
    }
}