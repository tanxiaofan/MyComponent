package com.github.tanxiaofan.router.service

import android.content.Context
import android.util.Log
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.facade.service.DegradeService
import com.github.tanxiaofan.router.LIFECYCLE
import com.github.tanxiaofan.router.PROVIDER
import com.github.tanxiaofan.router.main.IMain
import com.github.tanxiaofan.router.utils.navigation

/**
 *
 * @Description:    降级策略，处理路由失败的情况
 * @Author:         fan.tan
 * @CreateDate:     2019/11/21 18:26
 */
@Route(path = "/xxx/xxx")
class AppDegradeService : DegradeService {
    override fun onLost(context: Context?, postcard: Postcard) {
        Log.d("tanfan", "AppDegradeService, path = ${postcard.path}")
        if (postcard.path.endsWith(PROVIDER)) {
            return
        }
        if (postcard.path.endsWith(LIFECYCLE)) {
            return
        }
        IMain.MAIN_MAIN.navigation()
    }

    override fun init(context: Context?) {}
}