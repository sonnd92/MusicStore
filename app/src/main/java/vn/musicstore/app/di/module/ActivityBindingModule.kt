package vn.musicstore.app.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import vn.musicstore.app.modules.auth.login.ui.LoginActivity

@Module
abstract class
ActivityBindingModule {
    @ContributesAndroidInjector()
    abstract fun loginActivity(): LoginActivity
}