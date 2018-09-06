package vn.musicstore.app.basic

import vn.musicstore.app.MsApplication
import vn.musicstore.app.di.component.DaggerPresenterComponent
import vn.musicstore.app.di.component.PresenterComponent
import vn.musicstore.app.di.module.MsAppModule
import vn.musicstore.app.modules.auth.login.LoginPresenter

abstract class BaseUIPresenter<out V : IBaseView>(protected val view: V) {

    private val injector: PresenterComponent = DaggerPresenterComponent
            .builder()
            .baseView(view)
            .appModule(MsAppModule(view.getContext()))
            .build()

    init {
        inject()
    }

    abstract fun onViewCreated()

    abstract fun onViewDestroyed()

    fun inject() {
        when (this) {
            is LoginPresenter -> injector.inject(this)
        }
    }
}