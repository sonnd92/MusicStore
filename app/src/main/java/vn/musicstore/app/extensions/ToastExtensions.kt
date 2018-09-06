@file:Suppress("NOTHING_TO_INLINE")

package vn.musicstore.app.extensions

import android.content.Context
import android.support.annotation.StringRes
import android.app.Fragment
import android.widget.Toast
/**
 * Declare base show toast fun to display the simple Toast message, which extend from application base context
 *
 * @param [message:CharSequence|StringRes messageResId: Int] the message.
 */
inline fun Context.toast(message: CharSequence) = Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

inline fun Context.toast(@StringRes messageResId: Int) =  Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show()

inline fun Context.longToast(message: CharSequence) =  Toast.makeText(this, message, Toast.LENGTH_LONG).show()

inline fun Context.longToast(@StringRes messageResId: Int) =  Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show()

/**
 * Display the simple Toast message with the LENGTH_SHORT duration.
 *
 * @param message the message text.
 */
inline fun Fragment.toast(message: CharSequence) = activity.toast(message)
/**
 * Display the simple Toast message with the LENGTH_SHORT duration.
 *
 * @param message the message text resource.
 */
inline fun Fragment.toast(message: Int) = activity.toast(message)

/**
 * Display the simple Toast message with the LENGTH_LONG duration.
 *
 * @param message the message text resource.
 */
inline fun Fragment.longToast(message: Int) = activity.longToast(message)

/**
 * Display the simple Toast message with the LENGTH_LONG duration.
 *
 * @param message the message text.
 */
inline fun Fragment.longToast(message: CharSequence) = activity.longToast(message)