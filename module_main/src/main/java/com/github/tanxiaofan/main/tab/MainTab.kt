package com.github.tanxiaofan.main.tab

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.github.tanxiaofan.main.R

/**
 *
 * @Description:    主页的 tab，封装 tab 选中状态相关逻辑，以及保存对应 fragment 的路由 path
 * @Author:         fan.tan
 * @CreateDate:     2019/11/27 13:52
 */
class MainTab @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private var tvName: TextView

    private var tabName: String? = null
    private var tabTag: String? = null

    //当前tab是否被选中
    private var tabChecked: Boolean = false

    init {
        LayoutInflater.from(context).inflate(R.layout.main_layout_tab_view, this, true)
        applyAttr(attrs, context, defStyleAttr)

        tvName = findViewById(R.id.tv_name)
        tvName.text = tabName
    }

    private fun applyAttr(attrs: AttributeSet?, context: Context, defStyleAttr: Int) {
        attrs?.let {
            val typedArray =
                context.obtainStyledAttributes(it, R.styleable.MainTab, defStyleAttr, -1)

            tabName = typedArray.getString(R.styleable.MainTab_main_tab_name)
            tabTag = typedArray.getString(R.styleable.MainTab_main_tab_tag)

            typedArray.recycle()
        }
    }

    fun getTabTag(): String {
        return tabTag ?: ""
    }

    fun setTabStatus(checked: Boolean) {
        if (tabChecked == checked) {
            return
        }
        if (checked) {
            setTabChecked()
        } else {
            setTabUnChecked()
        }
    }

    fun getTabStatus(): Boolean {
        return tabChecked
    }

    private fun setTabChecked() {
        tabChecked = true
        setBackgroundColor(Color.YELLOW)
    }

    private fun setTabUnChecked() {
        tabChecked = false
        setBackgroundColor(Color.WHITE)
    }
}