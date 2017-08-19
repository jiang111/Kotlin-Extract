package com.jyuesong.android.kotlin.extract

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction

/**
 * Created by jiang on 2017/8/19.
 */

inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> Unit) {
    val fragmentTransaction = beginTransaction()
    fragmentTransaction.func()
    fragmentTransaction.commit()
}

fun FragmentActivity._addFragment(fragment: Fragment, frameId: Int) {
    supportFragmentManager.inTransaction { add(frameId, fragment) }
}

fun FragmentActivity._replaceFragment(fragment: Fragment, frameId: Int) {
    supportFragmentManager.inTransaction { replace(frameId, fragment) }
}

fun FragmentActivity._switchFragment(from: Fragment?, to: Fragment, frameId: Int) {
    supportFragmentManager.inTransaction {
        if (from == null) {
            replace(frameId, to)
        } else {
            if (!to.isAdded) {
                hide(from).add(frameId, to)
            } else {
                hide(from).show(to)
            }

        }
    }
}