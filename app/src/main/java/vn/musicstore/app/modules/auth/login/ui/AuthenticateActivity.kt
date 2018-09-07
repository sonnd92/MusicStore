package vn.musicstore.app.modules.auth.login.ui

import android.content.Intent
import android.os.Bundle
import vn.musicstore.app.R
import vn.musicstore.app.basic.BaseActivity
import vn.musicstore.app.extensions.longToast
import vn.musicstore.app.modules.auth.login.AuthenticatePresenter
import vn.musicstore.app.modules.auth.login.IAuthenticateView
import vn.musicstore.app.modules.home.ui.HomeActivity
import vn.musicstore.app.prefs.UserSaved
import javax.inject.Inject

class AuthenticateActivity : BaseActivity<AuthenticatePresenter>(), IAuthenticateView {
    override fun onAuthenticated(successfully: Boolean) {
        if (successfully) {
            val homeIntent = Intent(this, HomeActivity::class.java)
            homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            homeIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(homeIntent)
            longToast("Đăng nhập thành công, chào mừng bạn quay trờ lại với Cisum")
        } else {
            val loginIntent = Intent(this, LoginActivity::class.java)
            loginIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            loginIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(loginIntent)
            longToast("Không thể xác minh tài khoản của bạn, vui lòng đăng nhập lại")
        }

        finish()
    }

    @Inject
    lateinit var userSaved: UserSaved

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirm_sign_in_callback)

        onAuthenticate()
    }

    private fun onAuthenticate() {
        val intent = intent
        val emailLink = intent.data!!.toString()
        mPresenter.authenticateEmailViaFirebase(emailLink)
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.onViewDestroyed()
    }

    override fun initiatePresenter(): AuthenticatePresenter = AuthenticatePresenter(this)
}
