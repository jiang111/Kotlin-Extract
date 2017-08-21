package com.jyuesong.android.kotlin.extract.impl

import android.util.Log
import org.json.JSONArray
import org.json.JSONObject

/**
 * Created by jiang on 2017/8/21.
 */
object LogImpl {

    internal var TAG: String = "log"

    private var DEBUG: Boolean = true

    internal const val LEVEL_V = 0
    internal const val LEVEL_D = 1
    internal const val LEVEL_I = 2
    internal const val LEVEL_W = 3
    internal const val LEVEL_E = 4
    internal const val LEVEL_JSON = 5

    fun init(debug: Boolean, tag: String) {
        TAG = tag
        DEBUG = debug
    }


    internal fun log_msg(tag: String, msg: String, level: Int) {

        if (!DEBUG) return

        when (level) {
            LEVEL_V -> Log.v(tag, msg)
            LEVEL_D -> Log.d(tag, msg)
            LEVEL_I -> Log.i(tag, msg)
            LEVEL_W -> Log.w(tag, msg)
            LEVEL_E -> Log.e(tag, msg)
            LEVEL_JSON -> {
                try {
                    val json = JSONObject(msg)
                    Log.d(tag, json.toString(4))
                } catch (e: Exception) {
                    Log.d(tag, e.toString())
                }
            }

        }

    }

    internal fun log_json(msg: JSONObject, tag: String) {
        if (!DEBUG) return
        Log.d(tag, msg.toString(4))

    }

    internal fun log_json(msg: JSONArray, tag: String) {
        if (!DEBUG) return
        Log.d(tag, msg.toString(4))
    }

}