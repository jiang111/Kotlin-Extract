package com.jyuesong.android.kotlinutils

import android.app.Activity
import android.app.Fragment
import android.os.Build
import android.os.Looper
import com.jyuesong.android.kotlinutils.thread.BackgroundExecutor
import java.util.concurrent.Future

/**
 * Created by jiang on 2017/8/17.
 */


inline fun async(crossinline f: () -> Unit) {
    BackgroundExecutor.submit {
        f()
    }
}

inline fun Activity.runUI(crossinline f: () -> Unit) {
    if (Thread.currentThread() == Looper.getMainLooper().thread) {
        f()
    } else {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            if (!this?.isDestroyed) this?.runOnUiThread { f() }
        } else {
            this?.runOnUiThread {
                f()
            }
        }

    }
}


private val crashLogger = { throwable: Throwable -> throwable.printStackTrace() }

fun <T> T.async(
        exceptionHandler: ((Throwable) -> Unit)? = crashLogger,
        f: T.() -> Unit
): Future<Unit> {
    return BackgroundExecutor.submit {
        return@submit try {
            f()
        } catch (thr: Throwable) {
            val result = exceptionHandler?.invoke(thr)
            if (result != null) {
                result
            } else {
                Unit
            }
        }
    }
}

inline fun Fragment.runUI(crossinline f: () -> Unit) {
    this?.activity?.runUI { f() }
}


inline fun android.support.v4.app.Fragment.runUI(crossinline f: () -> Unit) {
    this?.activity?.runUI { f() }
}


inline fun runUI(crossinline f: () -> Unit) {
    BackgroundExecutor.handler.post { f() }

}