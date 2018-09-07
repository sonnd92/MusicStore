package vn.musicstore.app.di.component

import dagger.BindsInstance
import dagger.Component
import vn.musicstore.app.basic.IBaseView
import vn.musicstore.app.di.module.ClientStorageModule
import vn.musicstore.app.di.module.MsAppModule
import vn.musicstore.app.di.module.NetworkModule
import vn.musicstore.app.di.module.ServerServiceModule
import vn.musicstore.app.modules.auth.login.AuthenticatePresenter
import vn.musicstore.app.modules.auth.login.LoginPresenter
import javax.inject.Singleton

@Singleton
@Component(modules = [
    MsAppModule::class,
    ClientStorageModule::class,
    NetworkModule::class,
    ServerServiceModule::class])
interface PresenterComponent{

    fun inject(presenter: LoginPresenter)
    fun inject(presenter: AuthenticatePresenter)

    @Component.Builder
    interface Builder{
        @BindsInstance
        fun baseView(baseView: IBaseView): Builder

        fun appModule(msAppModule: MsAppModule): Builder

        fun build(): PresenterComponent
    }
}