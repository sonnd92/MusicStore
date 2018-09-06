package vn.musicstore.app.basic

import android.support.annotation.IdRes
import android.support.v7.widget.Toolbar

interface IBaseUISetup {
    fun setToolbar(toolbar: Toolbar)
    fun setToolbarTitle(toolbarTitle: String)
    fun setMainContentView(@IdRes mainContentResId: Int)

    fun initViews()
    fun bindingViews()
    fun unbindViews()
}