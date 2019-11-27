package com.github.tanxiaofan.router.service

import android.content.Context
import android.net.Uri
import android.util.Log
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.facade.service.PathReplaceService

/**
 *
 * @Description:    重写跳转URL实现重定向
 * @Author:         fan.tan
 * @CreateDate:     2019/11/23 10:53
 */
@Route(path = "/xxx/xxx")
class AppPathReplaceService : PathReplaceService {

    override fun forString(path: String): String {
        Log.d("tanfan", "AppPathReplaceService, path = $path")
        return path
    }

    override fun forUri(uri: Uri): Uri {
        Log.d("tanfan", "AppPathReplaceService, uri = $uri")
        return uri
    }

    override fun init(context: Context?) {
    }
}