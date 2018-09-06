@file:Suppress("NOTHING_TO_INLINE")

package vn.musicstore.app.extensions

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.os.Build
import android.view.View


fun View.isRealVisible(): Boolean {
    if (visibility != View.VISIBLE) {
        return false
    }
    return if (parent === rootView)
        visibility == View.VISIBLE
    else
        (parent as View).isRealVisible()
}

fun View.getRelativeTop(): Int {
    return if (parent === rootView)
        top
    else
        top + (parent as View).getRelativeTop()
}

fun View.show(animationTime:Long) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
        visibility = View.VISIBLE
        animate()
            .setDuration(animationTime)
            .alpha(1f)
            .setListener(object : AnimatorListenerAdapter() {
                    override fun onAnimationEnd(animation: Animator) {
                        visibility = View.VISIBLE
                    }
                })
    } else {
        // The ViewPropertyAnimator APIs are not available, so simply show
        // and hide the relevant UI components.
        visibility = View.VISIBLE
    }
}

fun View.hide(animationTime: Long) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
        visibility = View.GONE
        animate()
                .setDuration(animationTime)
                .alpha(0f)
                .setListener(object : AnimatorListenerAdapter() {
                    override fun onAnimationEnd(animation: Animator) {
                        visibility = View.GONE
                    }
                })
    } else {
        // The ViewPropertyAnimator APIs are not available, so simply show
        // and hide the relevant UI components.
        visibility = View.GONE
    }
}