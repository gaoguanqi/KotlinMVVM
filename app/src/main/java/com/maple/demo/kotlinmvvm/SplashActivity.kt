package com.maple.demo.kotlinmvvm

import android.content.Intent
import android.os.Bundle
import com.maple.demo.kotlinmvvm.app.base.BaseActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        runBlocking {
            // 阻塞3s
            delay(3000L)
            startActivity( Intent(this@SplashActivity,HomeActivity::class.java))
            this@SplashActivity.finish()
        }
    }
}
