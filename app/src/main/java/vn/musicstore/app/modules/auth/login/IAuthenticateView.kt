package vn.musicstore.app.modules.auth.login

import vn.musicstore.app.basic.IBaseView

interface IAuthenticateView : IBaseView {
    fun onAuthenticated(successfully: Boolean)
}