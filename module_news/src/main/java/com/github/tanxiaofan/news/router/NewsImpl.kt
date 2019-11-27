package com.github.tanxiaofan.news.router

import com.alibaba.android.arouter.facade.annotation.Route
import com.github.tanxiaofan.router.news.INews

/**
 *
 * @Description:
 * @Author:         fan.tan
 * @CreateDate:     2019/11/26 17:37
 */
@Route(path = INews.NEWS_PROVIDER)
class NewsImpl : INews