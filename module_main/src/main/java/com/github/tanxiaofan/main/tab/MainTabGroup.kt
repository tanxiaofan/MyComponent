package com.github.tanxiaofan.main.tab

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.children
import androidx.fragment.app.FragmentManager
import com.github.tanxiaofan.main.R

/**
 *
 * @Description:    主页 tab 的容器，管理所有 tab
 * @Author:         fan.tan
 * @CreateDate:     2019/11/27 14:08
 */
class MainTabGroup @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private var containerId: Int = 0
    private var layoutId: Int = 0

    init {
        applyAttr(attrs, context, defStyleAttr)
        LayoutInflater.from(context).inflate(layoutId, this, true)
        initView()
    }

    private fun applyAttr(attrs: AttributeSet?, context: Context, defStyleAttr: Int) {
        attrs?.let {
            val typedArray =
                context.obtainStyledAttributes(it, R.styleable.MainTabGroup, defStyleAttr, -1)

            containerId =
                typedArray.getResourceId(R.styleable.MainTabGroup_main_tab_group_container, -1)

            layoutId = typedArray.getResourceId(R.styleable.MainTabGroup_main_tab_group_layout, -1)

            typedArray.recycle()
        }

        if (containerId == -1 || layoutId == -1) {
            throw IllegalArgumentException("MainTabGroup must specify main_tab_group_container and main_tab_group_layout !")
        }
    }

    private fun Context.findActivity(): Activity? {
        return when (this) {
            is Activity -> this
            is ContextWrapper -> this.baseContext.findActivity()
            else -> null
        }
    }

    private fun findSupportFragmentManager(): FragmentManager {
        return (context.findActivity() as AppCompatActivity).supportFragmentManager
    }

    /**
     * 遍历寻找布局下所有的 MainTab
     */
    private fun ViewGroup.findAllMainTab(): List<MainTab> {
        val list = mutableListOf<MainTab>()
        children.forEach {
            when (it) {
                is MainTab -> list.add(it)
                is ViewGroup -> list.addAll(it.findAllMainTab())
                else -> {
                }
            }
        }
        return list
    }

    private fun initView() {
        val allTab = findAllMainTab()
        val appTabManager = AppTabManager(allTab, findSupportFragmentManager(), containerId)

        //点击切换
        allTab.forEach {
            it.setOnClickListener { v ->
                appTabManager.switch(v as MainTab)
            }
        }
    }

    fun allTabs(): List<MainTab> {
        return findAllMainTab()
    }
}