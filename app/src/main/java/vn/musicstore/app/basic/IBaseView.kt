package vn.musicstore.app.basic

import android.content.Context

interface IBaseView {
    /**
     * @return the context which the view is running in
     * */
    fun getContext():Context
}