package vn.musicstore.app

import android.os.Build
import com.google.firebase.FirebaseApp
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import uk.co.chrisjenx.calligraphy.CalligraphyConfig
import vn.musicstore.app.delegates.DelegateExts
import vn.musicstore.app.di.component.DaggerMsAppComponent
import vn.musicstore.app.di.module.MsAppModule
import com.google.firebase.auth.ActionCodeSettings



class MsApplication: DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerMsAppComponent
                .builder()
                .application(this)
                .appModule(MsAppModule(applicationContext))
                .build()
    }

    companion object {
        private var mAppInstance : MsApplication by DelegateExts.notNullSingleValue()

        public fun instance() = mAppInstance
    }

    override fun onCreate() {
        super.onCreate()
        mAppInstance = this
        //initialize custom font
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {
            CalligraphyConfig.initDefault(CalligraphyConfig.Builder()
                    .setDefaultFontPath("font/Averta.otf")
                    .setFontAttrId(R.attr.fontPath)
                    .build()
            )
        }

        FirebaseApp.initializeApp(this)
    }

}