package com.jyuesong.android.kotlin.extract.impl

import android.app.Activity
import android.content.Intent
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