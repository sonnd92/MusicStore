package vn.musicstore.app.modules.splash.ui

import android.content.Intent
import android.os.Bundle
import vn.musicstore.app.basic.BaseActivity
import vn.musicstore.app.modules.auth.login.ui.LoginActivity
import vn.musicstore.app.modules.home.ui.HomeActivity
import vn.musicstore.app.modules.splash.ISplashView
import vn.musicstore.app.modules.splash.SplashPresenter
import vn.musicstore.app.prefs.UserSaved
import javax.inject.Inject
import android.view.WindowManager
import android.os.Build

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
class SplashActivity : BaseActivity<SplashPresenter>(), ISplashView {
    private val TAG = "SplashActivity"

    @Inject
    lateinit var userSaved: UserSaved

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            val w = window // in Activity's onCreate() for instance
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        }
//        setContentView(R.layout.activity_splash)

        if (userSaved.isLoggedIn()) {
            val homeActivity = Intent(this, HomeActivity::class.java)
            startActivity(homeActivity)
        }else{
            val loginIntent = Intent(this, LoginActivity::class.java)
            startActivity(loginIntent)
        }

        finish()
    }

    override fun initiatePresenter(): SplashPresenter = SplashPresenter(this)
}
