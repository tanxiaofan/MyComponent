package com.github.tanxiaofan.main

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.github.tanxiaofan.base.BaseActivity
import com.github.tanxiaofan.main.utils.TaskGroup
import com.github.tanxiaofan.router.login.ILogin
import com.github.tanxiaofan.router.main.IMain
import com.github.tanxiaofan.router.personal.IPersonal
import com.github.tanxiaofan.router.utils.navigation
import com.github.tanxiaofan.router.utils.toPostCard
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.main_activity_main.*
import java.util.concurrent.TimeUnit

@Route(path = IMain.MAIN_MAIN)
class MainActivity : BaseActivity() {

    @JvmField
    @Autowired(name = ILogin.LOGIN_PROVIDER)
    var iLogin: ILogin? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity_main)

        //默认选中第一个 tab
        tab_group.allTabs()[0].performClick()
    }

    fun dealClick(view: View) {
        when (view.id) {
            R.id.btn_login -> ILogin.LOGIN_MAIN.toPostCard()
                .withString("name", "Mike")
                .withInt("age", 20)
                .withIntegerArrayList("intList", arrayListOf(1, 2, 3))
                .withStringArrayList("strList", arrayListOf("Rose", "Jack"))
                .navigation(this)
            R.id.btn_login_password -> ILogin.LOGIN_PASSWORD.navigation()
            R.id.btn_is_login -> {
                val loginSuccess = iLogin?.isLoginSuccess().toString()
                Toast.makeText(this, loginSuccess, Toast.LENGTH_SHORT).show()
            }
            R.id.btn_personal -> IPersonal.PERSONAL_MAIN.navigation()
            R.id.btn_scheme -> {
//                Uri.parse("arouter://m.aliyun.com${IPersonal.PERSONAL_MAIN}").navigation()
                val uri = Uri.parse("arouter://m.aliyun.com${IPersonal.PERSONAL_MAIN}")
                startActivity(Intent(Intent.ACTION_VIEW, uri))
            }
            R.id.btn_show -> {
                showGuideDialog()
            }
            else -> {
            }
        }
    }

    private fun showGuideDialog() {
        TaskGroup()
            .addTask(-2) { iTask ->
                AlertDialog.Builder(this@MainActivity)
                    .setTitle("guide 2")
                    .setMessage("message")
                    .setPositiveButton(
                        "ok"
                    ) { _, _ ->
                        //do nothing
                    }
                    .setOnDismissListener {
                        iTask.finishTask()
                    }
                    .show()
            }
            .addTask(1) {
                Toast.makeText(this@MainActivity, "guide 1", Toast.LENGTH_SHORT).show()
                it.finishTask()
            }
            .addTask(-3) {
                Observable.just(1)
                    .delay(2, TimeUnit.SECONDS)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doFinally {
                        Toast.makeText(this@MainActivity, "guide 3", Toast.LENGTH_SHORT).show()
                        it.finishTask()
                    }
                    .subscribe()
            }
            .start()
    }

}
