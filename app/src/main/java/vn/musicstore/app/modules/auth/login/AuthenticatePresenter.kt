package vn.musicstore.app.modules.auth.login

import android.content.Intent
import com.google.firebase.auth.FirebaseAuth
import vn.musicstore.app.basic.BasePresenter
import vn.musicstore.app.extensions.longToast
import vn.musicstore.app.modules.auth.login.ui.LoginActivity
import vn.musicstore.app.modules.home.ui.HomeActivity
import vn.musicstore.app.prefs.UserSaved
import javax.inject.Inject

class AuthenticatePresenter(view : IAuthenticateView) : BasePresenter<IAuthenticateView>(view) {
    @Inject
    lateinit var userSaved: UserSaved

    override fun onViewCreated() {
    }

    override fun onViewDestroyed() {
    }

    fun authenticateEmailViaFirebase(emailLink: String) {
        val auth = FirebaseAuth.getInstance()
        // Confirm the link is a sign-in with email link.
        if (auth.isSignInWithEmailLink(emailLink)) {
            val unconfirmedEmail = userSaved.getUnconfirmedEmail()

            // The client SDK will parse the code from the link for you.
            auth.signInWithEmailLink(unconfirmedEmail, emailLink)
                    .addOnCompleteListener { task ->
                        view.onAuthenticated(task.isSuccessful)
                        if (task.isSuccessful) {
                            userSaved.setIsLoggedIn(true)
                            userSaved.setFirebaseEmailLink(emailLink)
                            userSaved.setEmail(unconfirmedEmail)
                        }
                    }
        }else{
            view.onAuthenticated(false)
        }
    }
}