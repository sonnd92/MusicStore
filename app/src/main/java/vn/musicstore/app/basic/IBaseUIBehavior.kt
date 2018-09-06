package vn.musicstore.app.basic

import android.content.Context
import android.view.View

interface IBaseUIBehavior {
    fun showNotFoundView(message: String = "")
    fun showErrorView(errorMsg: String, drawableResId: Int)
    fun showLoadingDialog()

    fun hideNotFoundView()
    fun hideErrorView()
    fun hideLoadingDialog()

    fun showContentView()
    fun showLoadingView()

    fun hideContentView()
    fun hideLoadingView()
}