package com.github.tanxiaofan.router.interceptor

import android.content.Context
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.callback.InterceptorCallback
import com.alibaba.android.arouter.facade.template.IInterceptor
import com.github.tanxiaofan.router.login.ILogin
import com.github.tanxiaofan.router.utils.hasExtra
import com.github.tanxiaofan.router.utils.navigation
import com.github.tanxiaofan.router.utils.toPostCard

/**
 *
 * @Description:    拦截器，处理未登录的情况
 * @Author:         fan.tan
 * @CreateDate:     2019/11/18 18:23
 */
class LoginInterceptor : IInterceptor {

    private var iLogin: ILogin? = null

    override fun process(postcard: Postcard?, callback: InterceptorCallback?) {
        postcard?.extra?.let {
            if (it hasExtra ILogin.EXTRA_NEED_LOGIN) {
                if (iLogin?.isLoginSuccess() == false) {
                    //need login
                    ILogin.LOGIN_MAIN.toPostCard()
                        .with(postcard.extras)
                        .navigation()
                    callback?.onInterrupt(RuntimeException("need login"))
                    return
                }
            }
        }
        callback?.onContinue(postcard)
    }

    override fun init(context: Context?) {
        iLogin = ILogin.LOGIN_PROVIDER.navigation() as? ILogin
    }
}