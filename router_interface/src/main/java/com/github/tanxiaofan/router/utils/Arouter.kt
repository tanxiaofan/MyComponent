package com.github.tanxiaofan.router.utils

import android.net.Uri
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.launcher.ARouter

/**
 *
 * @Description:    新增 ARouter 相关扩展函数
 * @Author:         fan.tan
 * @CreateDate:     2019/11/20 15:15
 */

/**
 * 根据 path 构建 Postcard 对象，使用更加灵活
 */
fun String.toPostCard(): Postcard {
    return ARouter.getInstance().build(this)
}

/**
 * 根据 Uri 构建 Postcard 对象，使用更加灵活
 */
fun Uri.toPostCard(): Postcard {
    return ARouter.getInstance().build(this)
}

/**
 * 直接跳转 path,不能携带参数
 */
fun String.navigation(): Any? {
    return this.toPostCard().navigation()
}

/**
 * 直接跳转 Uri,不能携带参数
 */
fun Uri.navigation(): Any? {
    return ARouter.getInstance().build(this).navigation()
}

/**
 * 判断路由中的 extra 是否含有特定标志位
 */
infix fun Int.hasExtra(flag: Int): Boolean {
    return this and flag == flag
}