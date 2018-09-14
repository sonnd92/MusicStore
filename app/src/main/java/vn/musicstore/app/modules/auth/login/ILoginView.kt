package vn.musicstore.app.modules.auth.login

import vn.musicstore.app.basic.IBaseUIBehavior
import vn.musicstore.app.basic.IBaseView

interface ILoginView : IBaseView, IBaseUIBehavior {
    fun onLogged()
    fun onLoginFailure(errorMessage: String)

    fun onLoginByEmail(successfully: Boolean)

    fun onLoginViaGoogle()

    fun onLoginViaFacebook()
}