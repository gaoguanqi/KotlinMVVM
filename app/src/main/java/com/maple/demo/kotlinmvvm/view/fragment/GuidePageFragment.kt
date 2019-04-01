package com.maple.demo.kotlinmvvm.view.fragment

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.blankj.utilcode.util.SPUtils
import com.maple.demo.kotlinmvvm.R
import com.maple.demo.kotlinmvvm.app.base.BaseFragment
import com.maple.demo.kotlinmvvm.app.config.AppConstants
import com.maple.demo.kotlinmvvm.view.activity.HomeActivity
import kotlinx.android.synthetic.main.fragment_guide_page.*

/**
 * author: gaogq
 * time: 2019/3/29 11:34
 * description:
 */
class GuidePageFragment : BaseFragment(){
    companion object {
        fun newInstance(index: Int): GuidePageFragment {
            val fragment = GuidePageFragment()
            val bundle = Bundle()
            bundle.putInt(AppConstants.BundleKey.EXTRA_INDEX, index)
            fragment.setArguments(bundle)
            return fragment
        }
    }

    override fun layoutResID(): Int = R.layout.fragment_guide_page


    override fun initData(view: View, savedInstanceState: Bundle?) {
        var mIndex:Int? = arguments?.getInt(AppConstants.BundleKey.EXTRA_INDEX)

        btn_start.setOnClickListener{
            SPUtils.getInstance().put(AppConstants.SaveInfoKey.HAS_WECLOME, true)
            startActivity(Intent(this.activity, HomeActivity::class.java))
            this.activity?.finish()
        }

        when(mIndex){
            0 -> btn_start.visibility = View.GONE
            1 -> btn_start.visibility = View.GONE
            2 -> btn_start.visibility = View.VISIBLE
        }
    }

}