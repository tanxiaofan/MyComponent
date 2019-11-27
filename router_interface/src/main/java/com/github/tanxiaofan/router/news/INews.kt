package com.github.tanxiaofan.router.news

import android.content.Context
import com.alibaba.android.arouter.facade.template.IProvider
import com.github.tanxiaofan.router.PROVIDER

/**
 *
 * @Description:
 * @Author:         fan.tan
 * @CreateDate:     2019/11/26 17:31
 */
interface INews : IProvider {

    override fun init(context: Context?) {}

    companion object {
        const val GROUP = "news"

        //provider
        const val NEWS_PROVIDER = "/$GROUP/$PROVIDER"

        //path
        const val NEWS_MAIN_FRAGMENT = "/$GROUP/main_fragment"
    }
}