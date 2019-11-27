package com.github.tanxiaofan.main.router

import android.app.Application
import android.util.Log
import com.alibaba.android.arouter.facade.annotation.Route
import com.github.tanxiaofan.router.app.IModuleLifecycle

/**
 *
 * @Description:
 * @Author:         fan.tan
 * @CreateDate:     2019/11/21 15:22
 */
@Route(path = IModuleLifecycle.LIFECYCLE_MAIN)
class MainLifeCycle : IModuleLifecycle {

    override fun onCreate(application: Application) {
        super.onCreate(application)
        Log.d("tanfan", "MainLifeCycle, onCreate")
    }
}