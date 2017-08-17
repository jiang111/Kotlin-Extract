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
fun Context.dip2px(value: Int): Int = CommonImpl.dip2px(this, value)

fun Context.px2dip(value: Int): Int = CommonImpl.px2dip(this, value)

fun Context.sp2px(value: Int): Int = CommonImpl.sp2px(this, value)

fun Context.px2sp(value: Int): Int = CommonImpl.px2sp(this, value)


/**
 * view
 */
fun View.dip2px(value: Int): Int = context.dip2px(value)

fun View.px2dip(value: Int): Int = context.px2dip(value)
fun View.sp2px(value: Int): Int = context.sp2px(value)

fun View.px2sp(value: Int): Int = context.px2sp(value)


/**
 * fragment
 */
fun Fragment.dip2px(value: Int): Int = activity.dip2px(value)

fun Fragment.px2dip(value: Int): Int = activity.px2dip(value)

fun Fragment.sp2px(value: Int): Int = activity.sp2px(value)

fun Fragment.px2sp(value: Int): Int = activity.px2sp(value)

fun android.support.v4.app.Fragment.dip2px(value: Int): Int = activity.dip2px(value)

fun android.support.v4.app.Fragment.px2dip(value: Int): Int = activity.px2dip(value)

fun android.support.v4.app.Fragment.sp2px(value: Int): Int = activity.sp2px(value)

fun android.support.v4.app.Fragment.px2sp(value: Int): Int = activity.px2sp(value)
