package vn.musicstore.app.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import vn.musicstore.app.utility.validation.InputForm

@Module
class ValidationModule {
    @Provides
    fun providesInputForm(context: Context) = InputForm(context)
}