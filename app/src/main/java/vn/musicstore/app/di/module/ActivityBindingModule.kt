package vn.musicstore.app.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import vn.musicstore.app.modules.auth.login.ui.LoginActivity
import vn.musicstore.app.modules.home.HomeActivity
import vn.musicstore.app.modules.splash.ui.SplashActivity

@Module
abstract class
ActivityBindingModule {

    @ContributesAndroidInjector()
    abstract fun loginActivity(): LoginActivity

    @ContributesAndroidInjector()
    abstract fun splashActivity(): SplashActivity

    @ContributesAndroidInjector()
    abstract fun homeActivity(): HomeActivity
}