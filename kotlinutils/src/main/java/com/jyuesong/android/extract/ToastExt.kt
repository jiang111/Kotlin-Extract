package com.jyuesong.android.kotlinutils

import android.app.Fragment
import android.content.Context
import android.view.View
import android.widget.Toast
import com.jyuesong.android.kotlinutils.impl.CommonImpl

/**
 * Created by jiang on 2017/8/17.
 */

/**
 * context
 */
fun Context.toast(msg: CharSequence) = CommonImpl.toast(context = this, msg = msg, time = Toast.LENGTH_SHORT)


fun Context.longtoast(msg: CharSequence) = CommonImpl.toast(context = this, msg = msg, time = Toast.LENGTH_LONG)


/**
 * view
 */
fun View.toast(msg: CharSequence) = context.toast(msg)


fun View.longtoast(msg: CharSequence) = context.longtoast(msg)


/**
 * fragment
 */
fun Fragment.toast(msg: CharSequence) = activity.toast(msg)


fun Fragment.longtoast(msg: CharSequence) = activity.longtoast(msg)


fun android.support.v4.app.Fragment.toast(msg: CharSequence) = activity.toast(msg)


fun android.support.v4.app.Fragment.longtoast(msg: CharSequence) = activity.longtoast(msg)


