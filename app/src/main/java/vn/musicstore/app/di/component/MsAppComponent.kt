package vn.musicstore.app.di.component

import android.app.Application
import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import vn.musicstore.app.MsApplication
import vn.musicstore.app.di.module.*
import vn.musicstore.app.modules.auth.login.ui.LoginActivity
import javax.inject.Singleton

@Singleton
@Component(modules = [
    MsAppModule::class,
    ClientStorageModule::class,
    PicassoModule::class,
    ActivityBindingModule::class,
    AndroidSupportInjectionModule::class])
interface MsAppComponent : AndroidInjector<MsApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): MsAppComponent.Builder

        fun appModule(msAppModule: MsAppModule): MsAppComponent.Builder

        fun build():MsAppComponent
    }

}