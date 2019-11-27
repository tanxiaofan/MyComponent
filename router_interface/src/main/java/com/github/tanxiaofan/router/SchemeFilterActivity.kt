package com.github.tanxiaofan.router

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.tanxiaofan.router.utils.navigation

class SchemeFilterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //todo 校验
        intent.data?.navigation()
        finish()
    }
}
