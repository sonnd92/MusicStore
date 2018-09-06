package vn.musicstore.app.modules.auth.login

import android.os.Handler
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.ActionCodeSettings
import vn.musicstore.app.basic.BaseUIPresenter
import vn.musicstore.app.extensions.toast
import com.google.firebase.auth.FirebaseAuth
import vn.musicstore.app.data.remote.service.UserService
import javax.inject.Inject
import com.google.android.gms.tasks.Task
import android.support.annotation.NonNull
import android.util.Log
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.internal.FirebaseAppHelper.getUid
import com.google.firebase.auth.FirebaseUser




class LoginPresenter(view: ILoginView) : BaseUIPresenter<ILoginView>(view) {

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
        val url = "https://2d2c0f20.ngrok.io/api/authentication/verify?uid=" + email
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