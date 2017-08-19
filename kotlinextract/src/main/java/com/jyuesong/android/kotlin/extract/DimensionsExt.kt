package com.jyuesong.android.kotlin.extract

import android.app.Fragment
import android.content.Context
import android.view.View
import com.jyuesong.android.kotlin.extract.impl.CommonImpl

/**
 * Created by jiang on 2017/8/17.
 */


/**
 * context
 */
fun Context._dip2px(value: Int): Int = CommonImpl.dip2px(this, value)

fun Context._px2dip(value: Int): Int = CommonImpl.px2dip(this, value)

fun Context._sp2px(value: Int): Int = CommonImpl.sp2px(this, value)

fun Context._px2sp(value: Int): Int = CommonImpl.px2sp(this, value)


/**
 * view
 */
fun View._dip2px(value: Int): Int = context._dip2px(value)

fun View._px2dip(value: Int): Int = context._px2dip(value)
fun View._sp2px(value: Int): Int = context._sp2px(value)

fun View._px2sp(value: Int): Int = context._px2sp(value)


/**
 * fragment
 */
fun Fragment._dip2px(value: Int): Int = activity._dip2px(value)

fun Fragment._px2dip(value: Int): Int = activity._px2dip(value)

fun Fragment._sp2px(value: Int): Int = activity._sp2px(value)

fun Fragment._px2sp(value: Int): Int = activity._px2sp(value)

fun android.support.v4.app.Fragment._dip2px(value: Int): Int = activity._dip2px(value)

fun android.support.v4.app.Fragment._px2dip(value: Int): Int = activity._px2dip(value)

fun android.support.v4.app.Fragment._sp2px(value: Int): Int = activity._sp2px(value)

fun android.support.v4.app.Fragment._px2sp(value: Int): Int = activity._px2sp(value)
