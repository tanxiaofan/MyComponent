package com.github.tanxiaofan.login

import android.os.Bundle
import android.util.Log
import android.view.View
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.github.tanxiaofan.base.BaseActivity
import com.github.tanxiaofan.router.login.ILogin

/**
 *
 * @Description:
 * @Author:         fan.tan
 * @CreateDate:     2019/11/14 18:34
 */
@Route(path = ILogin.LOGIN_MAIN, extras = ILogin.EXTRA_NEED_LOGIN)
class LoginActivity : BaseActivity() {

    @JvmField
    @Autowired
    var name: String? = null

    @JvmField
    @Autowired
    var age: Int? = 0

    //todo
    @JvmField
    @Autowired
    var intList: List<Int>? = listOf()

    @JvmField
    @Autowired(name = "stuList")
    var strList: List<String>? = listOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity_login)

        Log.d(
            "tanfan", """|name = $name
            |age = $age
            |intList = $intList
            |strList = $strList
        """.trimMargin()
        )
    }

    fun dealClick(view: View) {
        when (view.id) {
            R.id.btn_login -> UserManager.login()
            R.id.btn_login_out -> UserManager.loginOut()
            else -> {
            }
        }
    }
}