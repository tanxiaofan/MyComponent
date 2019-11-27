package com.github.tanxiaofan.personal.router

import android.content.Context
import com.alibaba.android.arouter.facade.annotation.Route
import com.github.tanxiaofan.router.personal.IPersonal
import com.github.tanxiaofan.router.personal.User

/**
 *
 * @Description:
 * @Author:         fan.tan
 * @CreateDate:     2019/11/20 11:12
 */
@Route(path = IPersonal.PERSONAL_PROVIDER)
class PersonalImpl : IPersonal {

    override fun getUser(): User {
        return User("Mike", 20)
    }
}