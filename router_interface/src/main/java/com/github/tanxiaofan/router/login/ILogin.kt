package com.github.tanxiaofan.router.login

import com.alibaba.android.arouter.facade.template.IProvider
import com.github.tanxiaofan.router.PROVIDER

/**
 *
 * @Description:    module_login 相关路由接口
 * @Author:         fan.tan
 * @CreateDate:     2019/11/20 11:14
 */
interface ILogin : IProvider {

    fun login()
    fun loginOut()
    fun isLoginSuccess(): Boolean

    companion object {

        const val GROUP = "login"

        //provider
        const val LOGIN_PROVIDER = "/$GROUP/$PROVIDER"

        //extra
        const val EXTRA_NEED_LOGIN = 0x1

        //path
        const val LOGIN_MAIN = "/$GROUP/main"
        const val LOGIN_PASSWORD = "/$GROUP/password"
    }
}