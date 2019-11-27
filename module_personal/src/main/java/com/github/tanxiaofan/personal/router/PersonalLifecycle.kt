package com.github.tanxiaofan.personal.router

import android.app.Application
import android.util.Log
import com.alibaba.android.arouter.facade.annotation.Route
import com.github.tanxiaofan.router.app.IModuleLifecycle

/**
 *
 * @Description:
 * @Author:         fan.tan
 * @CreateDate:     2019/11/20 17:12
 */
@Route(path = IModuleLifecycle.LIFECYCLE_PERSONAL)
class PersonalLifecycle : IModuleLifecycle {
    override fun onCreate(application: Application) {
        super.onCreate(application)
        Log.d("tanfan", "PersonalLifecycle, onCreate")
    }
}