package com.github.tanxiaofan.router.app

import android.app.Application
import android.content.Context
import android.content.res.Configuration
import com.alibaba.android.arouter.facade.template.IProvider
import com.github.tanxiaofan.router.LIFECYCLE
import com.github.tanxiaofan.router.home.IHome
import com.github.tanxiaofan.router.login.ILogin
import com.github.tanxiaofan.router.main.IMain
import com.github.tanxiaofan.router.news.INews
import com.github.tanxiaofan.router.personal.IPersonal

/**
 *
 * @Description:    子 module Application相关生命周期,不同module的路由路径的一级命名不能相同
 * @Author:         fan.tan
 * @CreateDate:     2019/11/20 16:10
 */
interface IModuleLifecycle : IProvider {

    fun onCreate(application: Application) {}

    fun onTerminate(application: Application) {}

    fun onConfigurationChanged(application: Application, newConfig: Configuration) {}

    fun onLowMemory(application: Application) {}

    fun onTrimMemory(application: Application, level: Int) {}

    override fun init(context: Context?) {}


    companion object {
        const val LIFECYCLE_LOGIN = "/${ILogin.GROUP}/$LIFECYCLE"
        const val LIFECYCLE_PERSONAL = "/${IPersonal.GROUP}/$LIFECYCLE"
        const val LIFECYCLE_MAIN = "/${IMain.GROUP}/$LIFECYCLE"
        const val LIFECYCLE_NEWS = "/${INews.GROUP}/$LIFECYCLE"
        const val LIFECYCLE_HOME = "/${IHome.GROUP}/$LIFECYCLE"

        val lifecycleList = listOf(
            LIFECYCLE_LOGIN,
            LIFECYCLE_PERSONAL,
            LIFECYCLE_MAIN,
            LIFECYCLE_NEWS,
            LIFECYCLE_HOME
        )
    }
}

