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
fun Context.loadColor(@ColorRes id: Int): Int = CommonImpl.loadColor(this, id)

fun Context.loadDrawable(@ColorRes id: Int): Drawable = CommonImpl.loadDrawable(this, id)


/**
 * view
 */
fun View.loadColor(@ColorRes id: Int): Int = context.loadColor(id)

fun View.loadDrawable(@ColorRes id: Int): Drawable = context.loadDrawable(id)


/**
 * fragment
 */
fun Fragment.loadColor(@ColorRes id: Int): Int = activity.loadColor(id)

fun Fragment.loadDrawable(@ColorRes id: Int): Drawable = activity.loadDrawable(id)

fun android.support.v4.app.Fragment.loadColor(@ColorRes id: Int): Int = activity.loadColor(id)

fun android.support.v4.app.Fragment.loadDrawable(@ColorRes id: Int): Drawable = activity.loadDrawable(id)