package com.github.tanxiaofan.news.router

import android.app.Application
import android.util.Log
import com.alibaba.android.arouter.facade.annotation.Route
import com.github.tanxiaofan.router.app.IModuleLifecycle

/**
 *
 * @Description:
 * @Author:         fan.tan
 * @CreateDate:     2019/11/26 17:38
 */
@Route(path = IModuleLifecycle.LIFECYCLE_NEWS)
class NewsLifecycle : IModuleLifecycle {
    override fun onCreate(application: Application) {
        super.onCreate(application)
        Log.d("tanfan", "NewsLifecycle, onCreate")
    }
}