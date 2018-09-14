package vn.musicstore.app.modules.auth.login

import com.google.firebase.auth.ActionCodeSettings
import com.google.firebase.auth.FirebaseAuth
import vn.musicstore.app.basic.BasePresenter
import vn.musicstore.app.data.remote.service.UserService
import vn.musicstore.app.modules.auth.login.ui.LoginActivity
import vn.musicstore.app.prefs.UserSaved
import javax.inject.Inject


class LoginPresenter(view: ILoginView) : BasePresenter<ILoginView>(view) {

    private val TAG = "LoginPresenter"
    val mAuth = FirebaseAuth.getInstance()

    @Inject
    lateinit var userService: UserService

    @Inject
    lateinit var userSaved: UserSaved

    override fun onViewCreated() {
    }

    override fun onViewDestroyed() {
    }

    fun loginEmailLinkBase(email: String) {

        //initialize firebase authentication
        val url = "https://2d2c0f20.ngrok.io/api/authentication/verify?uid=$email"
        val actionCodeSettings = ActionCodeSettings.newBuilder()
                .setUrl(url)
                .setHandleCodeInApp(true)
                // The default for this is populated with the current android package name.
                .setAndroidPackageName("vn.musicstore.app", false, null)
                .build()

        mAuth.sendSignInLinkToEmail(email, actionCodeSettings)
                .addOnCompleteListener { task ->
                    view.onLoginByEmail(task.isSuccessful)
                    if (task.isSuccessful) {
                        userSaved.setUnconfirmedEmail(email)
                    }
                }
    }

    fun loginEmailPasswordBase(email: String, password: String) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener((view.getContext() as LoginActivity))  { task ->
                    if (task.isSuccessful) {
                        view.onLogged()
                        val user = mAuth.currentUser
                        userSaved.setEmail(user?.email.toString())
                        userSaved.setAvatar(user?.photoUrl.toString())
                        userSaved.setFullName(user?.displayName.toString())
                    } else {
                        view.onLoginFailure("Xác minh tài khoản thất bại. Vui lòng kiểm tra lại email hoặc mật khẩu")
                    }
                }

    }

}