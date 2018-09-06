package vn.musicstore.app.di.module

import android.content.Context
import dagger.Module
import com.google.firebase.auth.ActionCodeSettings
import dagger.Provides
import javax.inject.Singleton

@Module
class MsAppModule(val context: Context) {

    @Provides
    fun providesContext() = context.applicationContext
}