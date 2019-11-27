package com.github.tanxiaofan.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alibaba.android.arouter.facade.annotation.Route
import com.github.tanxiaofan.base.BaseFragment
import com.github.tanxiaofan.router.home.IHome
import kotlinx.android.synthetic.main.home_fragment.*

/**
 *
 * @Description:
 * @Author:         fan.tan
 * @CreateDate:     2019/11/26 18:23
 */
@Route(path = IHome.HOME_MAIN_FRAGMENT)
class HomeFragment : BaseFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return layoutInflater.inflate(R.layout.home_fragment, null, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        tv_home.setOnClickListener {
            startActivity(Intent(activity, HomeDetailActivity::class.java))
        }
    }
}