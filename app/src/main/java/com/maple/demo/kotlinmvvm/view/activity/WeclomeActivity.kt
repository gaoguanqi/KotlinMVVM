package com.maple.demo.kotlinmvvm.view.activity

import android.os.Bundle
import com.maple.demo.kotlinmvvm.R
import com.maple.demo.kotlinmvvm.app.base.BaseActivity
import com.maple.demo.kotlinmvvm.app.base.BaseFragment
import com.maple.demo.kotlinmvvm.view.adapter.WeclomePagerAdapter
import com.maple.demo.kotlinmvvm.view.fragment.GuidePageFragment
import kotlinx.android.synthetic.main.activity_weclome.*

class WeclomeActivity : BaseActivity() {
    override fun layoutResID(): Int = R.layout.activity_weclome

    lateinit var mList:ArrayList<BaseFragment>

    override fun initCreate(savedInstanceState: Bundle?) {
        mList = arrayListOf(GuidePageFragment.newInstance(0),GuidePageFragment.newInstance(1),GuidePageFragment.newInstance(2))
        vp_weclome.adapter = WeclomePagerAdapter(this@WeclomeActivity.supportFragmentManager, mList)
    }

    override fun useTransStateBar() = true
}
