package com.jyuesong.android.kotlin.extract.impl

import android.content.Context
import android.graphics.drawable.Drawable
import android.support.annotation.ColorRes
import android.support.annotation.DrawableRes
import android.support.v4.content.ContextCompat
import android.widget.Toast

/**
 * Created by jiang on 2017/8/17.
 */
internal object CommonImpl {

    fun toast(context: Context, msg: CharSequence, time: Int) {
        Toast.makeText(context.applicationContext, msg, time).show();
    }

    fun dip2px(context: Context, dip: Int): Int {
        val scale = context.applicationContext.resources.displayMetrics.density
        return (dip * scale + 0.5f).toInt()
    }

    fun px2dip(context: Context, px: Int): Int {
        val scale = context.applicationContext.resources.displayMetrics.density
        return (px / scale + 0.5f).toInt()
    }

    fun sp2px(context: Context, sp: Int): Int {
        val fontScale = context.applicationContext.resources.displayMetrics.scaledDensity
        return (sp * fontScale + 0.5f).toInt()
    }

    fun px2sp(context: Context, px: Int): Int {
        val fontScale = context.applicationContext.resources.displayMetrics.scaledDensity
        return (px / fontScale + 0.5f).toInt()
    }

    fun loadColor(context: Context, @ColorRes id: Int): Int {
        return ContextCompat.getColor(context, id)
    }

    fun loadDrawable(context: Context, @DrawableRes id: Int): Drawable {
        return ContextCompat.getDrawable(context, id)
    }


}