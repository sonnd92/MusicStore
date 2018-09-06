package vn.musicstore.app.modules.auth.login

import android.os.Handler
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.ActionCodeSettings
import vn.musicstore.app.basic.BaseUIPresenter
import vn.musicstore.app.extensions.toast
import com.google.firebase.auth.FirebaseAuth
import vn.musicstore.app.data.remote.service.UserService
import javax.inject.Inject


class LoginPresenter(view: ILoginView) : BaseUIPresenter<ILoginView>(view) {
    @Inject
    lateinit var userService: UserService

    override fun onViewCreated() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onViewDestroyed() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun login(email: String, password: String) {

        view.onLogged()
        //initialize firebase authentication
//        FirebaseApp.initializeApp(view.getContext())
//        val mFirebaseAuth = FirebaseAuth.getInstance()
//        mFirebaseAuth.sendSignInLinkToEmail(email, actionCodeSettings)
    }

}