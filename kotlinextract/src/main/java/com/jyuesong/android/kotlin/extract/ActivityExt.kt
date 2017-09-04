package com.jyuesong.android.kotlin.extract

import android.app.Activity
import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.view.inputmethod.InputMethodManager

/**
 * Created by jiang on 2017/8/19.
 */

inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> Unit) {
    val fragmentTransaction = beginTransaction()
    fragmentTransaction.func()
    fragmentTransaction.commit()
}

inline fun android.app.FragmentManager.inTransaction(func: android.app.FragmentTransaction.() -> Unit) {
    val fragmentTransaction = beginTransaction()
    fragmentTransaction.func()
    fragmentTransaction.commit()
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

fun FragmentActivity._switchFragment(from: android.app.Fragment?, to: android.app.Fragment, frameId: Int) {
    fragmentManager.inTransaction {
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

fun Activity.hideKeyboard(): Boolean {
    val view = currentFocus
    view?.let {
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        return inputMethodManager.hideSoftInputFromWindow(view.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
    }
    return false
}

