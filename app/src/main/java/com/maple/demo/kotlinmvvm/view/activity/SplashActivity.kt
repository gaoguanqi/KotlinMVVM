package com.maple.demo.kotlinmvvm.view.activity

import android.content.Intent
import android.os.Bundle
import com.blankj.utilcode.util.SPUtils
import com.maple.demo.kotlinmvvm.R
import com.maple.demo.kotlinmvvm.app.base.BaseActivity
import com.maple.demo.kotlinmvvm.app.config.AppContent
import com.maple.demo.kotlinmvvm.widget.timer.MyCountDownTimer
import com.maple.demo.kotlinmvvm.widget.timer.OnTimerCallback
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : BaseActivity(), OnTimerCallback {

    var timer:MyCountDownTimer? = null

    override fun onTimerStart() {
        tv_time.setText(0.toString())
    }

    override fun onTimerTick(millis: Long) {
        tv_time.setText((millis/1000).toString())
    }

    override fun onTimerEnd() {
        launchTarget()
    }

    private fun launchTarget() {
        if (SPUtils.getInstance().getBoolean(AppContent.savekey_has_weclome, false)) {
            startActivity(Intent(this@SplashActivity, HomeActivity::class.java))
        } else {
            startActivity(Intent(this@SplashActivity, WeclomeActivity::class.java))
            SPUtils.getInstance().put(AppContent.savekey_has_weclome, true)
        }
        this@SplashActivity.finish()
    }

    override fun layoutResID(): Int  = R.layout.activity_splash

    override fun initCreate(savedInstanceState: Bundle?) {
        timer = MyCountDownTimer(AppContent.value_timer_total,AppContent.value_timer_interval,this)
        timer?.start()
        tv_time.setOnClickListener{
            launchTarget()
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        timer?.cancel()
    }
}
