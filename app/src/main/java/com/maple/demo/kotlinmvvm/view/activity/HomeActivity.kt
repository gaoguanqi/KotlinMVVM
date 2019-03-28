package com.maple.demo.kotlinmvvm.view.activity

import android.os.Bundle
import android.view.KeyEvent
import com.maple.demo.kotlinmvvm.R
import com.maple.demo.kotlinmvvm.app.base.BaseActivity
import org.jetbrains.anko.toast

class HomeActivity : BaseActivity() {
    override fun layoutResID(): Int  = R.layout.activity_home

    var lastBackPressedMillis:Long = 0


    override fun initCreate(savedInstanceState: Bundle?) {

    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK){
            if(lastBackPressedMillis + 2000 > System.currentTimeMillis()){
                //moveTaskToBack(true)
                this@HomeActivity.finish()
            }else{
                lastBackPressedMillis = System.currentTimeMillis()
                toast("再按一次退出程序")
            }
            return true
        }
        return super.onKeyDown(keyCode, event)
    }
}
