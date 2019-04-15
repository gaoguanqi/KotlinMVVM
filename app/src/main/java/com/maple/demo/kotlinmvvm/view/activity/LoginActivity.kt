package com.maple.demo.kotlinmvvm.view.activity

import android.os.Bundle
import com.maple.demo.kotlinmvvm.R
import com.maple.demo.kotlinmvvm.app.MyApplication
import com.maple.demo.kotlinmvvm.app.base.BaseActivity
import com.maple.demo.kotlinmvvm.utils.LogUtils
import com.maple.jetpackdemo.room.AppDatabase
import com.maple.jetpackdemo.room.User
import kotlinx.android.synthetic.main.activity_login.*

/**
 * author: gaogq
 * time: 2019/4/3 13:15
 * description:
 */
class LoginActivity : BaseActivity() {
    override fun layoutResID(): Int = R.layout.activity_login

    override fun initCreate(savedInstanceState: Bundle?) {
        val database: AppDatabase = AppDatabase.getInstance(MyApplication.instance)
//        btn_login.setOnClickListener{
//            if (database.userDao().getAllUser().isEmpty()) {
//
//            }
//        }
//
//
//
//
//        btn_users.setOnClickListener {
//            val users = database.userDao().getAllUser();
//            for (user in users) {
//                LogUtils.logGGQ("user id:${user.id}--name:${user.name}")
//            }
//        }
    }

    override fun onContentView() {
        super.onContentView()
    }
}