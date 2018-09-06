package vn.musicstore.app.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.Reusable
import vn.musicstore.app.prefs.AppSharePreference
import vn.musicstore.app.prefs.UserSaved
import javax.inject.Singleton

@Module
class ClientStorageModule {
    @Singleton
    @Provides
    fun providesAppSharePreference(ctx: Context) = AppSharePreference(ctx)

    @Singleton
    @Provides
    fun provideUserSaved(sharePreference: AppSharePreference) = UserSaved(sharePreference)
}