@file:Suppress("NOTHING_TO_INLINE")

package vn.musicstore.app.extensions

import android.app.Activity
import android.app.Fragment
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager


inline fun Context.hideSoftInput(view: View) {

    val imm = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(view.windowToken, 0)
}

inline fun Context.showSoftInput() {
    val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY)
}

inline fun Fragment.hideSoftInput(view: View) = activity.hideSoftInput(view)

inline fun Fragment.showSoftInput() = activity.showSoftInput()
