package com.jyuesong.android.extract.kotlin.thread

import android.os.Handler
import android.os.Looper
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.Future

/**
 * Created by jiang on 2017/8/17.
 */
object BackgroundExecutor {
    val executor: ExecutorService  by lazy {
        Executors.newScheduledThreadPool(2 * Runtime.getRuntime().availableProcessors())
    }


    val handler: Handler by lazy {
        Handler(Looper.getMainLooper())
    }

    fun <T> submit(task: () -> T): Future<T> {
        return executor.submit(task)
    }

}