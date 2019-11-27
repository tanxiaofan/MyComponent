package com.github.tanxiaofan.home.router

import android.app.Application
import android.util.Log
import com.alibaba.android.arouter.facade.annotation.Route
import com.github.tanxiaofan.router.app.IModuleLifecycle

/**
 *
 * @Description:
 * @Author:         fan.tan
 * @CreateDate:     2019/11/26 18:28
 */
@Route(path = IModuleLifecycle.LIFECYCLE_HOME)
class HomeLifecycle : IModuleLifecycle {

    override fun onCreate(application: Application) {
        super.onCreate(application)
        Log.d("tanfan", "HomeLifecycle, onCreate")
    }
}