package com.github.tanxiaofan.login

import android.widget.Toast
import com.github.tanxiaofan.base.BaseApp

/**
 *
 * @Description:
 * @Author:         fan.tan
 * @CreateDate:     2019/11/14 18:39
 */
object UserManager {

    private var isLogin = false

    fun login() {
        //todo
        isLogin = true
        Toast.makeText(BaseApp.instance, "login success", Toast.LENGTH_SHORT).show()
    }

    fun loginOut() {
        isLogin = false
        Toast.makeText(BaseApp.instance, "login out success", Toast.LENGTH_SHORT).show()
    }

    fun isLoginSuccess(): Boolean {
        return isLogin
    }
}