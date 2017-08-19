package com.jyuesong.android.kotlin.extract.impl

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Fragment
import android.app.Service
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Parcelable
import java.io.Serializable

/**
 * Created by jiang on 2017/8/19.
 */

object IntentImpl {


    fun startAcivity(from: Activity, to: Class<out Activity>, params: Array<out Pair<String, Any?>>) {
        val intent = Intent(from, to)
        intent.putExtras(bundleOf(params))
        from.startActivity(intent)

    }

    fun startActivityForResult(from: Activity, to: Class<out Activity>, requestCode: Int, params: Array<out Pair<String, Any>>) {
        val intent = Intent(from, to)
        intent.putExtras(bundleOf(params))
        from.startActivityForResult(intent, requestCode)
    }


    fun startActivityForResult(from: Fragment, to: Class<out Activity>, requestCode: Int, params: Array<out Pair<String, Any>>) {
        val intent = Intent(from.activity, to)
        intent.putExtras(bundleOf(params))
        from.startActivityForResult(intent, requestCode)
    }

    fun startActivityForResult(from: android.support.v4.app.Fragment, to: Class<out Activity>, requestCode: Int, params: Array<out Pair<String, Any>>) {
        val intent = Intent(from.activity, to)
        intent.putExtras(bundleOf(params))
        from.startActivityForResult(intent, requestCode)
    }

    fun startService(context: Context, to: Class<out Service>, params: Array<out Pair<String, Any>>) {
        val intent = Intent(context, to)
        intent.putExtras(bundleOf(params))
        context.startService(intent)

    }


    fun email(context: Context, email: String, subject: String = "", text: String = ""): Boolean {
        val intent = Intent(Intent.ACTION_SENDTO)
        intent.data = Uri.parse("mailto:")
        intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(email))
        if (subject.isNotEmpty())
            intent.putExtra(Intent.EXTRA_SUBJECT, subject)
        if (text.isNotEmpty())
            intent.putExtra(Intent.EXTRA_TEXT, text)
        if (intent.resolveActivity(context.packageManager) != null) {
            context.startActivity(intent)
            return true
        }
        return false

    }

    @SuppressLint("MissingPermission")
    fun makeCall(context: Context, number: String): Boolean {
        try {
            val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:$number"))
            context.startActivity(intent)
            return true
        } catch (e: Exception) {
            e.printStackTrace()
            return false
        }
    }

    fun browse(context: Context, url: String, newTask: Boolean = false): Boolean {
        try {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            if (newTask) {
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }
            context.startActivity(intent)
            return true
        } catch (e: ActivityNotFoundException) {
            e.printStackTrace()
            return false
        }
    }

    fun share(context: Context, text: String, subject: String = ""): Boolean {
        try {
            val intent = Intent(android.content.Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(android.content.Intent.EXTRA_SUBJECT, subject)
            intent.putExtra(android.content.Intent.EXTRA_TEXT, text)
            context.startActivity(Intent.createChooser(intent, null))
            return true
        } catch (e: ActivityNotFoundException) {
            e.printStackTrace()
            return false
        }
    }

    fun sendSMS(context: Context, number: String, text: String = ""): Boolean {
        try {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("sms:$number"))
            intent.putExtra("sms_body", text)
            context.startActivity(intent)
            return true
        } catch (e: Exception) {
            e.printStackTrace()
            return false
        }
    }

    fun bundleOf(params: Array<out Pair<String, Any?>>): Bundle {
        val b = Bundle()
        for (p in params) {
            val (k, v) = p
            when (v) {
                null -> b.putSerializable(k, null)
                is Boolean -> b.putBoolean(k, v)
                is Byte -> b.putByte(k, v)
                is Char -> b.putChar(k, v)
                is Short -> b.putShort(k, v)
                is Int -> b.putInt(k, v)
                is Long -> b.putLong(k, v)
                is Float -> b.putFloat(k, v)
                is Double -> b.putDouble(k, v)
                is String -> b.putString(k, v)
                is CharSequence -> b.putCharSequence(k, v)
                is Parcelable -> b.putParcelable(k, v)
                is Serializable -> b.putSerializable(k, v)
                is BooleanArray -> b.putBooleanArray(k, v)
                is ByteArray -> b.putByteArray(k, v)
                is CharArray -> b.putCharArray(k, v)
                is DoubleArray -> b.putDoubleArray(k, v)
                is FloatArray -> b.putFloatArray(k, v)
                is IntArray -> b.putIntArray(k, v)
                is LongArray -> b.putLongArray(k, v)
                is Array<*> -> {
                    @Suppress("UNCHECKED_CAST")
                    when {
                        v.isArrayOf<Parcelable>() -> b.putParcelableArray(k, v as Array<out Parcelable>)
                        v.isArrayOf<CharSequence>() -> b.putCharSequenceArray(k, v as Array<out CharSequence>)
                        v.isArrayOf<String>() -> b.putStringArray(k, v as Array<out String>)
                        else -> throw Exception("Unsupported bundle component (${v.javaClass})")
                    }
                }
                is ShortArray -> b.putShortArray(k, v)
                is Bundle -> b.putBundle(k, v)
                else -> throw Exception("Unsupported bundle component (${v.javaClass})")
            }
        }

        return b
    }


}