package com.github.tanxiaofan.main.tab

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.github.tanxiaofan.base.BaseFragment
import com.github.tanxiaofan.base.manager.fragment.AppFragmentManager
import com.github.tanxiaofan.main.R
import com.github.tanxiaofan.router.utils.navigation

/**
 *
 * @Description:    业务层，tab切换，fragment切换
 * @Author:         fan.tan
 * @CreateDate:     2019/11/27 11:15
 */
class AppTabManager(
    private val tabs: List<MainTab>,
    private val fragmentManager: FragmentManager,
    private val containerId: Int
) {

    private val appFragmentManager: AppFragmentManager by lazy {
        AppFragmentManager(fragmentManager, containerId) {
            it.navigation() as? Fragment ?: EmptyFragment()
        }
    }

    /**
     * 切换
     */
    fun switch(view: MainTab) {
        switchTab(view)
        switchFragment(view)
    }

    private fun switchTab(view: MainTab) {
        tabs.forEach {
            it.setTabStatus(it == view)
        }
    }

    private fun switchFragment(tab: MainTab) {
        appFragmentManager.navigate(tab.getTabTag())
    }
}

class EmptyFragment : BaseFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return layoutInflater.inflate(R.layout.main_empty_fragment, null, false)
    }
}