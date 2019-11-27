package com.github.tanxiaofan.personal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alibaba.android.arouter.facade.annotation.Route
import com.github.tanxiaofan.base.BaseFragment
import com.github.tanxiaofan.router.personal.IPersonal
import com.github.tanxiaofan.router.utils.navigation
import kotlinx.android.synthetic.main.personal_fragment_main.*

/**
 *
 * @Description:
 * @Author:         fan.tan
 * @CreateDate:     2019/11/26 18:34
 */
@Route(path = IPersonal.PERSONAL_MAIN_FRAGMENT)
class PersonalFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return layoutInflater.inflate(R.layout.personal_fragment_main, null, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        tv_personal.setOnClickListener {
            IPersonal.PERSONAL_MAIN.navigation()
        }
    }
}