package vn.musicstore.app.basic

import android.app.Fragment
import android.content.Context
import android.view.View

abstract class BaseFragment : Fragment(), IBaseUISetup, IBaseUIBehavior {

    override fun showContentView() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showNotFoundView(message: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showErrorView(errorMsg: String, drawableResId: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showLoadingDialog() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showLoadingView() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideContentView() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideNotFoundView() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideErrorView() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideLoadingDialog() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideLoadingView() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}