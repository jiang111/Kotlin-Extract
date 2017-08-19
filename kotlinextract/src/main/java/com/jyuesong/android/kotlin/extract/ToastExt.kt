package com.jyuesong.android.kotlin.extract

import android.app.Fragment
import android.content.Context
import android.view.View
import android.widget.Toast
import com.jyuesong.android.kotlin.extract.impl.CommonImpl

/**
 * Created by jiang on 2017/8/17.
 */

/**
 * context
 */
fun Context._toast(msg: CharSequence) = CommonImpl.toast(context = this, msg = msg, time = Toast.LENGTH_SHORT)


fun Context._long_toast(msg: CharSequence) = CommonImpl.toast(context = this, msg = msg, time = Toast.LENGTH_LONG)


/**
 * view
 */
fun View._toast(msg: CharSequence) = context._toast(msg)


fun View._long_toast(msg: CharSequence) = context._long_toast(msg)


/**
 * fragment
 */
fun Fragment._toast(msg: CharSequence) = activity._toast(msg)


fun Fragment._long_toast(msg: CharSequence) = activity._long_toast(msg)


fun android.support.v4.app.Fragment._toast(msg: CharSequence) = activity._toast(msg)


fun android.support.v4.app.Fragment._long_toast(msg: CharSequence) = activity._long_toast(msg)


