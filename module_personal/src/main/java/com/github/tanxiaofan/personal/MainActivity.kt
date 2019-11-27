package com.github.tanxiaofan.personal

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.github.tanxiaofan.base.BaseActivity
import com.github.tanxiaofan.router.personal.IPersonal

@Route(path = IPersonal.PERSONAL_MAIN)
class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.personal_activity_main)
    }
}
