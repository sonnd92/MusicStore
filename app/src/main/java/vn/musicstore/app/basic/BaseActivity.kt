package vn.musicstore.app.basic

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.widget.Toolbar
import android.view.View
import dagger.android.support.DaggerAppCompatActivity
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper
import vn.musicstore.app.R
import vn.musicstore.app.extensions.hide
import vn.musicstore.app.extensions.show

abstract class BaseActivity<P : BaseUIPresenter<IBaseView>> : DaggerAppCompatActivity(),
        IBaseView,
        IBaseUIBehavior,
        IBaseUISetup {

    protected lateinit var mPresenter: P

    private var mContentViewId = UIResourceConfig.CONTENT_VIEW_RES_ID
    private val mErrorViewId = UIResourceConfig.ERROR_VIEW_RES_ID
    private val mLoadingViewId = UIResourceConfig.LOADING_VIEW_RES_ID
    private val mNotFoundViewId = UIResourceConfig.NOT_FOUND_VIEW_RES_ID
    private val mCommonToolbarId = UIResourceConfig.TOOL_BAR_VIEW_RES_ID
    private val mBackBtnId = UIResourceConfig.BACK_BUTTON_VIEW_RES_ID
    private var mShortAnimTime: Long = 0

    private var vToolbar: Toolbar? = null
    private var mProgressDialog: AlertDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mPresenter = initiatePresenter()

        //region initialize loading dialog
        val builder = AlertDialog.Builder(this)
        builder.setCancelable(false)
        builder.setView(R.layout.layout_loading_dialog)
        mProgressDialog = builder.create()
        //endregion

        resources.getInteger(android.R.integer.config_shortAnimTime).toLong()
    }

    override fun initViews() {
    }

    override fun bindingViews() {
    }

    override fun unbindViews() {
    }

    override fun setToolbar(toolbar: Toolbar) {
        this.vToolbar = toolbar
    }

    override fun setToolbarTitle(toolbarTitle: String) {
        vToolbar?.title = toolbarTitle
    }

    override fun setMainContentView(mainContentResId: Int) {
        mContentViewId = mainContentResId
    }

    override fun showContentView() {
        findViewById<View>(mContentViewId)?.show(mShortAnimTime)
    }

    override fun showNotFoundView(message: String) {
        hideLoadingView()
        hideContentView()
        hideErrorView()
        findViewById<View>(mNotFoundViewId)?.show(mShortAnimTime)
    }

    override fun showErrorView(errorMsg: String, drawableResId: Int) {
        hideLoadingView()
        hideContentView()
        hideNotFoundView()
        findViewById<View>(mErrorViewId)?.show(mShortAnimTime)
    }

    override fun showLoadingView() {
        hideContentView()
        hideErrorView()
        hideNotFoundView()
        findViewById<View>(mLoadingViewId)?.show(mShortAnimTime)
    }

    override fun showLoadingDialog() {
        mProgressDialog?.show()

    }

    override fun hideContentView() {
        findViewById<View>(mContentViewId)?.hide(mShortAnimTime)
    }

    override fun hideNotFoundView() {
        findViewById<View>(mNotFoundViewId)?.hide(mShortAnimTime)
    }

    override fun hideErrorView() {
        findViewById<View>(mErrorViewId)?.hide(mShortAnimTime)
    }

    override fun hideLoadingDialog() {
        mProgressDialog?.dismiss()
    }

    override fun hideLoadingView() {
        findViewById<View>(mNotFoundViewId)?.hide(mShortAnimTime)
    }

    override fun getContext(): Context = this

    override fun attachBaseContext(newBase: Context?) {
        try {
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {
                super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase))
            } else {
                super.attachBaseContext(newBase)
            }
        } catch (e: Exception) {
            super.attachBaseContext(newBase)
        }
    }

    protected abstract fun initiatePresenter(): P
}