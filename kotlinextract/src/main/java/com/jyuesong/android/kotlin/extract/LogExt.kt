package com.jyuesong.android.kotlin.extract

import com.jyuesong.android.kotlin.extract.impl.LogImpl
import org.json.JSONArray
import org.json.JSONObject

/**
 * Created by jiang on 2017/8/21.
 */
fun Any._v(msg: String, tag: String = LogImpl.TAG) = LogImpl.log_msg(tag, msg, LogImpl.LEVEL_V)

fun Any._d(msg: String, tag: String = LogImpl.TAG) = LogImpl.log_msg(tag, msg, LogImpl.LEVEL_D)

fun Any._i(msg: String, tag: String = LogImpl.TAG) = LogImpl.log_msg(tag, msg, LogImpl.LEVEL_I)

fun Any._w(msg: String, tag: String = LogImpl.TAG) = LogImpl.log_msg(tag, msg, LogImpl.LEVEL_W)

fun Any._e(msg: String, tag: String = LogImpl.TAG) = LogImpl.log_msg(tag, msg, LogImpl.LEVEL_E)

fun Any._wtf(msg: String, tag: String = LogImpl.TAG) = LogImpl.log_msg(tag, msg, LogImpl.LEVEL_WTF)

fun Any._json(msg: String, tag: String = LogImpl.TAG) = LogImpl.log_msg(tag, msg, LogImpl.LEVEL_JSON)


fun Any._json(msg: JSONObject, tag: String = LogImpl.TAG) = LogImpl.log_json(msg, tag)


fun Any._json(msg: JSONArray, tag: String = LogImpl.TAG) = LogImpl.log_json(msg, tag)

