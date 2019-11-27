package com.github.tanxiaofan.router.home

import android.content.Context
import com.alibaba.android.arouter.facade.template.IProvider
import com.github.tanxiaofan.router.PROVIDER

/**
 *
 * @Description:
 * @Author:         fan.tan
 * @CreateDate:     2019/11/26 18:26
 */
interface IHome : IProvider {
    override fun init(context: Context?) {}

    companion object {

        const val GROUP = "home"

        //provider
        const val HOME_PROVIDER = "/$GROUP/$PROVIDER"

        //path
        const val HOME_MAIN_FRAGMENT = "/$GROUP/main_fragment"
    }
}