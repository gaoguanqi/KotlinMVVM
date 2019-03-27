package com.maple.demo.kotlinmvvm

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

class SplashActivity : AppCompatActivity() {

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
