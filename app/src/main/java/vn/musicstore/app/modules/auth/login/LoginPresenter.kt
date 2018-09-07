package vn.musicstore.app.modules.auth.login

import com.google.firebase.auth.ActionCodeSettings
import vn.musicstore.app.basic.BasePresenter
import com.google.firebase.auth.FirebaseAuth
import vn.musicstore.app.data.remote.service.UserService
import javax.inject.Inject
import android.util.Log


class LoginPresenter(view: ILoginView) : BasePresenter<ILoginView>(view) {

    private val TAG  = "LoginPresenter"

    @Inject
    lateinit var userService: UserService

    override fun onViewCreated() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onViewDestroyed() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun login(email: String, password: String) {

        //initialize firebase authentication
        val url = "https://2d2c0f20.ngrok.io/api/authentication/verify?uid=$email"
        val actionCodeSettings = ActionCodeSettings.newBuilder()
                .setUrl(url)
                .setHandleCodeInApp(true)
                // The default for this is populated with the current android package name.
                .setAndroidPackageName("vn.musicstore.app", false, null)
                .build()

        val auth = FirebaseAuth.getInstance()
        auth.sendSignInLinkToEmail(email, actionCodeSettings)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Log.d(TAG, "Email sent.")
                    }
                }
    }

}