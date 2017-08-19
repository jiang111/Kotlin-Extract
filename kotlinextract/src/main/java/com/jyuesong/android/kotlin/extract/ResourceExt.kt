package com.jyuesong.android.kotlin.extract

import android.app.Fragment
import android.content.Context
import android.graphics.drawable.Drawable
import android.support.annotation.ColorRes
import android.view.View
import com.jyuesong.android.kotlin.extract.impl.CommonImpl

/**
 * Created by jiang on 2017/8/17.
 */


/**
 * context
 */
fun Context._loadColor(@ColorRes id: Int): Int = CommonImpl.loadColor(this, id)

fun Context._loadDrawable(@ColorRes id: Int): Drawable = CommonImpl.loadDrawable(this, id)


/**
 * view
 */
fun View._loadColor(@ColorRes id: Int): Int = context._loadColor(id)

fun View._loadDrawable(@ColorRes id: Int): Drawable = context._loadDrawable(id)


/**
 * fragment
 */
fun Fragment._loadColor(@ColorRes id: Int): Int = activity._loadColor(id)

fun Fragment._loadDrawable(@ColorRes id: Int): Drawable = activity._loadDrawable(id)

fun android.support.v4.app.Fragment._loadColor(@ColorRes id: Int): Int = activity._loadColor(id)

fun android.support.v4.app.Fragment._loadDrawable(@ColorRes id: Int): Drawable = activity._loadDrawable(id)