package com.github.tanxiaofan.base

import android.app.Application
import android.content.res.Configuration
import com.alibaba.android.arouter.launcher.ARouter
import com.github.tanxiaofan.router.app.IModuleLifecycle
import com.github.tanxiaofan.router.utils.navigation

/**
 *
 * @Description:
 * @Author:         fan.tan
 * @CreateDate:     2019/11/15 16:49
 */
open class BaseApp : Application() {
    companion object {
        lateinit var instance: Application
    }

    private val moduleLifecycleList: List<IModuleLifecycle?> by lazy {
        val list = mutableListOf<IModuleLifecycle?>()
        IModuleLifecycle.lifecycleList.forEach {
            list.add(it.navigation() as? IModuleLifecycle)
        }
        list
    }

    override fun onCreate() {
        super.onCreate()
        initRouter()
        instance = this
        moduleLifecycleList.forEach {
            it?.onCreate(this)
        }
    }

    private fun initRouter() {
        if (BuildConfig.DEBUG) {
            ARouter.openDebug()
            ARouter.openLog()
        }
        ARouter.init(this)
    }

    override fun onTerminate() {
        super.onTerminate()
        moduleLifecycleList.forEach {
            it?.onTerminate(this)
        }
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        moduleLifecycleList.forEach {
            it?.onConfigurationChanged(this, newConfig)
        }
    }

    override fun onLowMemory() {
        super.onLowMemory()
        moduleLifecycleList.forEach {
            it?.onLowMemory(this)
        }
    }

    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
        moduleLifecycleList.forEach {
            it?.onTrimMemory(this, level)
        }
    }
}