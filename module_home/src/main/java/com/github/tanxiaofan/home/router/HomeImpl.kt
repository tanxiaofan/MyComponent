package com.github.tanxiaofan.home.router

import com.alibaba.android.arouter.facade.annotation.Route
import com.github.tanxiaofan.router.home.IHome

/**
 *
 * @Description:
 * @Author:         fan.tan
 * @CreateDate:     2019/11/26 18:27
 */
@Route(path = IHome.HOME_PROVIDER)
class HomeImpl : IHome