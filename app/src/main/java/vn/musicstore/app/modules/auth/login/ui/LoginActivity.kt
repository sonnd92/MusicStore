package vn.musicstore.app.modules.auth.login.ui

import android.annotation.TargetApi
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.common.api.ApiException
import kotlinx.android.synthetic.main.activity_login.*
import vn.musicstore.app.R
import vn.musicstore.app.basic.BaseActivity
import vn.musicstore.app.extensions.hide
import vn.musicstore.app.extensions.longToast
import vn.musicstore.app.extensions.show
import vn.musicstore.app.extensions.toast
import vn.musicstore.app.modules.auth.login.ILoginView
import vn.musicstore.app.modules.auth.login.LoginPresenter
import vn.musicstore.app.modules.home.ui.HomeActivity
import vn.musicstore.app.utility.validation.Field
import vn.musicstore.app.utility.validation.InputForm
import vn.musicstore.app.utility.validation.validator.IsEmail
import vn.musicstore.app.utility.validation.validator.IsRequired
import javax.inject.Inject

/**
 * A login screen that offers login via email/password.
 */
class LoginActivity : BaseActivity<LoginPresenter>(), ILoginView {
    private val RC_SIGN_IN = 1929
    override fun onLoginViaGoogle() {
//            var signInIntent = mGoogleSignInClient.getSignInIntent();
//            startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    override fun onLoginViaFacebook() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private val TAG = "LoginActivity"

    @Inject
    lateinit var mInputForm: InputForm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        // Set up the login form.
        initValidation()
        v_password.setOnEditorActionListener(TextView.OnEditorActionListener { _, id, _ ->
            if (id == EditorInfo.IME_ACTION_DONE || id == EditorInfo.IME_NULL) {
                attemptLogin()
                return@OnEditorActionListener true
            }
            false
        })

        v_email_sign_in_button.setOnClickListener { attemptLogin() }
    }

    private fun initValidation() {
        with(mInputForm) {
            wrapperId = R.id.login_form
            addField(Field.Builder(v_email)
                .validate(IsRequired("Vui lòng nhập địa chỉ email"))
                .validate(IsEmail("Vui lòng nhập đúng email"))
                .build())
        }
    }

    /**
     * Attempts to sign in the account specified by the login form.
     * If there are form errors (invalid email, missing fields, etc.), the
     * errors are presented and no actual login attempt is made.
     */
    private fun attemptLogin() {
        if (!mInputForm.isValid()) {
            return
        }

        showProgress(true)
        if (v_password.text.isNullOrEmpty()) {
            mPresenter.loginEmailLinkBase(v_email.text.toString())
        }else{
            mPresenter.loginEmailPasswordBase(v_email.text.toString(), v_password.text.toString())
        }
    }

    override fun onLoginByEmail(successfully: Boolean) {
        showProgress(false)

        if (successfully) {
            val emailConfirmationIntent = Intent(this, ConfirmSignInEmailActivity::class.java)
            startActivity(emailConfirmationIntent)
        }else{
            toast("Xin lỗi, chúng tôi không thể gửi email xác minh đến địa chỉ mà bạn cung cấp. Vui lòng thử lại sau")
        }
    }

    override fun onLoginFailure(errorMessage:String) {
        toast(errorMessage)
        showProgress(false)
    }

    override fun onLogged() {
        val homeIntent = Intent(this, HomeActivity::class.java)
        homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        homeIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(homeIntent)
        longToast("Đăng nhập thành công, chào mừng bạn quay trờ lại với Cisum")
    }

    /**
     * Shows the progress UI and hides the login form.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    private fun showProgress(show: Boolean) {
        val shortAnimTime = resources.getInteger(android.R.integer.config_shortAnimTime).toLong()
        // simply show and hide the relevant UI components.
        if (show) {
            login_progress.visibility = View.VISIBLE
        } else {
            login_progress.visibility = View.INVISIBLE
        }

        v_email_sign_in_button.text = getString(if(show) R.string.signing_in else R.string.action_sign_in)

        v_email.isEnabled = !show
        v_password.isEnabled = !show
        v_email_sign_in_button.isEnabled = !show
        v_fb_sign_in_button.isEnabled = !show
        v_google_sign_in_button.isEnabled = !show
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.onViewDestroyed()
    }


    override fun onActivityResult(requestCode:Int, resultCode:Int, data:Intent) {
        super.onActivityResult(requestCode, resultCode, data)

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            var task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                // Google Sign In was successful, authenticate with Firebase
                var account = task.getResult(ApiException::class.java)
//                firebaseAuthWithGoogle(account);
            } catch (e:ApiException) {
                // Google Sign In failed, update UI appropriately
//                Log.w(TAG, "Google sign in failed", e);
                // ...
            }
        }
    }
    override fun initiatePresenter(): LoginPresenter  = LoginPresenter(this)
}
