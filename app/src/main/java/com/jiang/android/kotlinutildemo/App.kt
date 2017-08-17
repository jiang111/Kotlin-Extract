package com.jiang.android.kotlinutildemo

import android.app.Application
import com.jyuesong.android.kotlin.extract.sp.SharedPreferenceImpl

/**
 * Created by jiang on 2017/8/17.
 */
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        SharedPreferenceImpl.init(this, "nama")

    }

}