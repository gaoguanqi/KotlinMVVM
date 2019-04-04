package com.maple.demo.kotlinmvvm.view.activity

import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import com.maple.demo.kotlinmvvm.R
import com.maple.demo.kotlinmvvm.app.base.BaseActivity
import com.maple.demo.kotlinmvvm.test.TestActivity
import com.maple.demo.kotlinmvvm.utils.ToastUtil
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : BaseActivity() {
    override fun layoutResID(): Int  = R.layout.activity_home
    var lastBackPressedMillis:Long = 0


    override fun initCreate(savedInstanceState: Bundle?) {
        btn_login.setOnClickListener {
            startActivity(Intent(this@HomeActivity,TestActivity::class.java))
        }
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK){
            if(lastBackPressedMillis + 2000 > System.currentTimeMillis()){
                //moveTaskToBack(true)
                this@HomeActivity.finish()
            }else{
                lastBackPressedMillis = System.currentTimeMillis()
                ToastUtil.showToast("再按一次退出程序")
            }
            return true
        }
        return super.onKeyDown(keyCode, event)
    }
}
