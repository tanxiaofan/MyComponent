package com.github.tanxiaofan.login.router

import android.content.Context
import com.alibaba.android.arouter.facade.annotation.Route
import com.github.tanxiaofan.login.UserManager
import com.github.tanxiaofan.router.login.ILogin

/**
 *
 * @Description:
 * @Author:         fan.tan
 * @CreateDate:     2019/11/15 16:23
 */
@Route(path = ILogin.LOGIN_PROVIDER)
class LoginImpl : ILogin {
    override fun login() {
        UserManager.login()
    }

    override fun loginOut() {
        UserManager.loginOut()
    }

    override fun isLoginSuccess(): Boolean {
        return UserManager.isLoginSuccess()
    }

    override fun init(context: Context?) {
    }
}