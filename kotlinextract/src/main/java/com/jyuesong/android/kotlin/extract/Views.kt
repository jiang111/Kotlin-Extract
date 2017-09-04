@file:Suppress("NOTHING_TO_INLINE")

package com.livinglifetechway.k4kotlin

import android.content.Context
import android.view.View
import android.view.ViewPropertyAnimator
import android.view.inputmethod.InputMethodManager
import android.widget.EditText

/**
 * Sets the view's visibility to GONE
 */
inline fun View.hide() {
    if (visibility != View.GONE)
        visibility = View.GONE
}

/**
 * Sets the view's visibility to VISIBLE
 */
inline fun View.show() {
    if (visibility != View.VISIBLE)
        visibility = View.VISIBLE
}

/**
 * Sets the view's visibility to INVISIBLE
 */
inline fun View.invisible() {
    if (visibility != View.INVISIBLE)
        visibility = View.INVISIBLE
}

/**
 * Toggle's view's visibility. If View is visible, then sets to gone. Else sets Visible
 */
inline fun View.toggle() {
    visibility = if (visibility == View.VISIBLE) View.GONE else View.VISIBLE
}

/**
 * Fades in the View
 */
inline fun View.fadeIn(duration: Long = 400): ViewPropertyAnimator? {
    return animate()
            .alpha(1.0f)
            .setDuration(duration)
}

/**
 * Fades out the View
 */
inline fun View.fadeOut(duration: Long = 400): ViewPropertyAnimator? {
    return animate()
            .alpha(0.0f)
            .setDuration(duration)
}


fun EditText.showKeyboard() {
    requestFocus()
    val inputMethodManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.showSoftInput(this, InputMethodManager.SHOW_FORCED)

}