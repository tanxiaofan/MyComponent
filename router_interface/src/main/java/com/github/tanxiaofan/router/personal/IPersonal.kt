package com.github.tanxiaofan.router.personal

import android.content.Context
import com.alibaba.android.arouter.facade.template.IProvider
import com.github.tanxiaofan.router.PROVIDER

/**
 *
 * @Description:    module_personal 相关路由接口
 * @Author:         fan.tan
 * @CreateDate:     2019/11/19 11:13
 */
interface IPersonal : IProvider {

    override fun init(context: Context?) {}

    companion object {

        const val GROUP = "personal"

        //provider
        const val PERSONAL_PROVIDER = "/$GROUP/$PROVIDER"

        //path
        const val PERSONAL_MAIN = "/$GROUP/main"

        const val PERSONAL_MAIN_FRAGMENT = "/$GROUP/main_fragment"

    }

    fun getUser(): User
}