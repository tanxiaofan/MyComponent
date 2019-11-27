package com.github.tanxiaofan.news

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alibaba.android.arouter.facade.annotation.Route
import com.github.tanxiaofan.base.BaseFragment
import com.github.tanxiaofan.router.news.INews
import kotlinx.android.synthetic.main.news_fragment.*

/**
 *
 * @Description:
 * @Author:         fan.tan
 * @CreateDate:     2019/11/26 17:28
 */
@Route(path = INews.NEWS_MAIN_FRAGMENT)
class NewsFragment : BaseFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return layoutInflater.inflate(R.layout.news_fragment, null, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        tv_news.setOnClickListener {
            startActivity(Intent(activity, NewsDetailActivity::class.java))
        }
    }
}