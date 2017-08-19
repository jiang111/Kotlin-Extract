package com.jyuesong.android.kotlin.extract

import android.app.Activity
import com.jyuesong.android.kotlin.extract.impl.IntentImpl

/**
 * Created by jiang on 2017/8/19.
 */

inline fun <reified T : Activity> Activity._startActivity(vararg params: Pair<String, Any>) {

    IntentImpl.startAcivity(this, T::class.java, params)
}

inline fun <reified T : Activity> Activity._startActivityForResult(requestCode: Int, vararg params: Pair<String, Any>) {

    IntentImpl.startActivityForResult(this, T::class.java,requestCode, params)
}



