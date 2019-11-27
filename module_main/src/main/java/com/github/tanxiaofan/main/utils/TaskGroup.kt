package com.github.tanxiaofan.main.utils

import android.util.Log
import android.util.SparseArray
import androidx.core.util.forEach

/**
 *
 * @Description:    顺序执行的一组任务
 * @Author:         fan.tan
 * @CreateDate:     2019/11/26 11:19
 */
class TaskGroup {

    private var tasks: Task? = null
    private val sparseArray = SparseArray<Task>()

    /**
     * 开始按顺序执行所有任务
     */
    fun start() {
        sparseArray.forEach { _, value ->
            value.next = tasks
            tasks = value
        }
        tasks?.start()
    }

    /**
     * 添加
     */
    fun addTask(priority: Int, worker: IWorker): TaskGroup {
        sparseArray.put(priority, Task(priority, worker))
        return this
    }

    /**
     * @return 任务数量
     */
    fun taskCount(): Int {
        return sparseArray.size()
    }

    /** 任务，链式结构
     * @param priority  不同任务的优先级必须不同，优先级大的先执行
     */
    private class Task(val priority: Int, val worker: IWorker) : ITask {

        var next: Task? = null
        private var isStarted = false

        override fun start() {
            if (isStarted) {
                return
            }
            isStarted = true
            Log.d("TaskFlow", "Task[$priority] start")
            worker.invoke(this)
        }

        override fun finishTask() {
            Log.d("TaskFlow", "Task[$priority] finished")
            next?.start()
        }

        override fun interrupt() {
            //do nothing
        }
    }

    /**
     * 任务
     */
    interface ITask {

        /**
         * 开始执行任务
         */
        fun start()

        /**
         * 结束此任务
         */
        fun finishTask()

        /**
         * 中断所有任务
         */
        fun interrupt()
    }
}

/**
 * 任务执行者，主动调用 task.finishTask() 表示此任务处理完成
 */
typealias IWorker = (TaskGroup.ITask) -> Unit
