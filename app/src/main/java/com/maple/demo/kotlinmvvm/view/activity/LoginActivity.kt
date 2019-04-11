package com.maple.demo.kotlinmvvm.view.activity

import android.os.Bundle
import com.maple.demo.kotlinmvvm.R
import com.maple.demo.kotlinmvvm.app.MyApplication
import com.maple.demo.kotlinmvvm.app.base.BaseActivity
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
        btn_login.setOnClickListener{

            val database:AppDatabase = AppDatabase.getInstance(MyApplication.instance)
            if (database.userDao().all.isEmpty()) {
                database.userDao().insertUser(User().also { it.name = "张三" })
            }
        }
    }

    override fun onContentView() {
        super.onContentView()
    }
}