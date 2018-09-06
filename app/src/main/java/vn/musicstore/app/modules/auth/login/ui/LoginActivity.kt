package vn.musicstore.app.modules.auth.login.ui

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.annotation.TargetApi
import android.app.LoaderManager.LoaderCallbacks
import android.content.CursorLoader
import android.content.Loader
import android.content.pm.PackageManager
import android.database.Cursor
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.ContactsContract
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.ArrayAdapter
import android.widget.TextView
import dagger.android.AndroidInjection
import vn.musicstore.app.R
import vn.musicstore.app.basic.BaseActivity
import vn.musicstore.app.extensions.toast
import vn.musicstore.app.modules.auth.login.ILoginView
import vn.musicstore.app.modules.auth.login.LoginPresenter
import java.util.*
import kotlinx.android.synthetic.main.activity_login.*
import vn.musicstore.app.MsApplication
import vn.musicstore.app.data.remote.service.UserService
import vn.musicstore.app.extensions.hide
import vn.musicstore.app.extensions.show
import javax.inject.Inject

/**
 * A login screen that offers login via email/password.
 */
class LoginActivity : BaseActivity<LoginPresenter>(), ILoginView {

    private val TAG = "LoginActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        // Set up the login form.
        v_password.setOnEditorActionListener(TextView.OnEditorActionListener { _, id, _ ->
            if (id == EditorInfo.IME_ACTION_DONE || id == EditorInfo.IME_NULL) {
                attemptLogin()
                return@OnEditorActionListener true
            }
            false
        })

        v_email_sign_in_button.setOnClickListener { attemptLogin() }
    }

    /**
     * Attempts to sign in the account specified by the login form.
     * If there are form errors (invalid email, missing fields, etc.), the
     * errors are presented and no actual login attempt is made.
     */
    private fun attemptLogin() {
        showProgress(true)
        v_email_sign_in_button.text = getString(R.string.signing_in)
        mPresenter.login(v_email.text.toString(), v_password.text.toString())
    }

    override fun onLoginFailure(errorMessage:String) {
        toast(errorMessage)
        showProgress(false)
        v_email_sign_in_button.text = getString(R.string.action_sign_in)
    }

    override fun onLogged() {
        toast("$TAG: Logged in")
    }

    /**
     * Shows the progress UI and hides the login form.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    private fun showProgress(show: Boolean) {
        val shortAnimTime = resources.getInteger(android.R.integer.config_shortAnimTime).toLong()
        // simply show and hide the relevant UI components.
        if (show) {
            login_progress.show(shortAnimTime)
        } else {
            login_progress.hide(shortAnimTime)
        }

        v_email.isEnabled = !show
        v_password.isEnabled = !show
        v_email_sign_in_button.isEnabled = !show
        v_fb_sign_in_button.isEnabled = !show
        v_google_sign_in_button.isEnabled = !show
    }

    override fun initiatePresenter(): LoginPresenter  = LoginPresenter(this)
}
