package com.github.tanxiaofan.login.router

import android.app.Application
import android.util.Log
import com.alibaba.android.arouter.facade.annotation.Route
import com.github.tanxiaofan.router.app.IModuleLifecycle

/**
 *
 * @Description:
 * @Author:         fan.tan
 * @CreateDate:     2019/11/20 17:09
 */
@Route(path = IModuleLifecycle.LIFECYCLE_LOGIN)
class LoginLifecycle : IModuleLifecycle {
    override fun onCreate(application: Application) {
        super.onCreate(application)
        Log.d("tanfan", "LoginLifecycle, onCreate")
    }
}