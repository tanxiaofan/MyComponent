package com.github.tanxiaofan.router.main

import android.content.Context
import com.alibaba.android.arouter.facade.template.IProvider
import com.github.tanxiaofan.router.PROVIDER

/**
 *
 * @Description:
 * @Author:         fan.tan
 * @CreateDate:     2019/11/21 10:54
 */
interface IMain : IProvider {
    override fun init(context: Context?) {}

    companion object {
        const val GROUP = "main"

        //provider
        const val MAIN_PROVIDER = "/$GROUP/$PROVIDER"

        //path
        const val MAIN_MAIN = "/$GROUP/main"
    }
}