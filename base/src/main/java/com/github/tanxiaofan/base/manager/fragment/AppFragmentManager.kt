package com.github.tanxiaofan.base.manager.fragment

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

/**
 *
 * @Description:    管理首页tab中的fragment创建和切换
 * @Author:         fan.tan
 * @CreateDate:     2019/11/12 14:39
 */
class AppFragmentManager(
    private val fragmentManager: FragmentManager,
    private val containerId: Int,
    private val fragmentCreator: ((String) -> Fragment) = defaultFragmentCreator
) {

    //当前显示的 fragment tag
    private var currentTag: String? = null

    /**
     * fragment 切换
     * 当 tag 是完整类名时，defaultFragmentCreator 才有效
     */
    fun navigate(
        tag: String,
        args: Bundle? = null
    ) {

        if (fragmentManager.isStateSaved) {
            Log.d(
                "AppFragmentManager",
                "Ignoring navigate() call: FragmentManager has already" + " saved its state"
            )
            return
        }

        //如果当前已经显示目标fragment，不处理
        if (TextUtils.equals(currentTag, tag)) {
            return
        }

        val ft = fragmentManager.beginTransaction()

        currentTag = tag

        //根据tag寻找fragment实例
        var frag = fragmentManager.findFragmentByTag(currentTag)

        //如果没有则新建一个fragment并添加
        if (frag == null) {
            frag = fragmentCreator.invoke(tag)
            ft.add(containerId, frag, currentTag)
        }

        //给fragment传参
        frag.arguments = args

        //显示隐藏
        fragmentManager.fragments.forEach {
            if (TextUtils.equals(it.tag, currentTag)) {
                ft.show(it)
            } else {
                ft.hide(it)
            }
        }

        ft.commit()
    }

    /**
     * 获取当前显示的 fragment
     */
    fun current(): Fragment? {
        return fragmentManager.findFragmentByTag(currentTag)
    }

    /**
     * 移除所有 fragment
     */
    fun removeAll() {
        if (fragmentManager.isStateSaved) {
            return
        }

        val ft = fragmentManager.beginTransaction()
        fragmentManager.fragments.forEach {
            ft.remove(it)
        }
        ft.commit()

        currentTag = null
    }


}

/**
 * 通过类名反射创建fragment
 */
private val defaultFragmentCreator = { tag: String ->
    Class.forName(tag).getConstructor().newInstance() as Fragment
}