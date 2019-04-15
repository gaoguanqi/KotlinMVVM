package com.maple.demo.kotlinmvvm.view.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.maple.demo.kotlinmvvm.R
import com.maple.demo.kotlinmvvm.app.MyApplication
import com.maple.demo.kotlinmvvm.utils.LogUtils
import com.maple.jetpackdemo.room.AppDatabase
import com.maple.jetpackdemo.room.User
import kotlinx.android.synthetic.main.activity_test.*

class TestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        var user:User? = null

        val database: AppDatabase = AppDatabase.getInstance(MyApplication.instance)

        btn1.setOnClickListener {
            database.userDao().getAllUser().let {
                LogUtils.logGGQ("isEmpty:${it.isEmpty()}")
            }
        }
        btn2.setOnClickListener {
            user = User()
            user?.name = "张三"
            database.userDao().insertUser(user!!)
        }

        btn3.setOnClickListener {
            val users = database.userDao().getAllUser();
            var user = users.first()
            user.name = "mapleee"
            database.userDao().updateUser(user)
        }

        btn4.setOnClickListener {
            val id = et_input.text.toString().toLong()
            val user = database.userDao().getUserById(id)
            database.userDao().deleteUser(user)
        }


        btn5.setOnClickListener {
            database.userDao().deleteAllUser(database.userDao().getAllUser())
        }

        btn6.setOnClickListener {
            val users = database.userDao().getAllUser();
            for (user in users) {
                LogUtils.logGGQ("查询所有user id:${user.id}---name:${user.name}")
            }
        }

    }
}
