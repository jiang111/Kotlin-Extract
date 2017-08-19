package com.jyuesong.android.kotlin.extract

import android.app.Activity
import android.app.Fragment
import android.app.Service
import android.content.Context
import com.jyuesong.android.kotlin.extract.impl.IntentImpl

/**
 * Created by jiang on 2017/8/19.
 */

inline fun <reified T : Activity> Activity._startActivity(vararg params: Pair<String, Any>) = IntentImpl.startAcivity(this, T::class.java, params)


inline fun <reified T : Activity> Activity._startActivityForResult(requestCode: Int, vararg params: Pair<String, Any>) = IntentImpl.startActivityForResult(this, T::class.java, requestCode, params)


inline fun <reified T : Activity> Fragment._startActivity(vararg params: Pair<String, Any>) = IntentImpl.startAcivity(activity, T::class.java, params)


inline fun <reified T : Activity> Fragment._startActivityForResult(requestCode: Int, vararg params: Pair<String, Any>) = IntentImpl.startActivityForResult(this, T::class.java, requestCode, params)


inline fun <reified T : Activity> android.support.v4.app.Fragment._startActivity(vararg params: Pair<String, Any>) = IntentImpl.startAcivity(activity, T::class.java, params)


inline fun <reified T : Activity> android.support.v4.app.Fragment._startActivityForResult(requestCode: Int, vararg params: Pair<String, Any>) = IntentImpl.startActivityForResult(this, T::class.java, requestCode, params)


inline fun <reified T : Service> Context._startService(vararg params: Pair<String, Any>) = IntentImpl.startService(this, T::class.java, params)


inline fun Context._browse(url: String, newTask: Boolean = false) = IntentImpl.browse(this, url, newTask)

inline fun Context._email(email: String, subject: String = "", text: String = "") = IntentImpl.email(this, email, subject, text)

inline fun Context._makeCall(number: String): Boolean = IntentImpl.makeCall(this, number)

inline fun Context._sendSMS(number: String, text: String = ""): Boolean = IntentImpl.sendSMS(this, number, text)
