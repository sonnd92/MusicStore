package vn.musicstore.app.di.module

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import vn.musicstore.app.data.remote.service.UserService
import javax.inject.Named
import javax.inject.Singleton

@Module
class ServerServiceModule {
    @Singleton
    @Provides
    fun providesUserService(@Named("ServerApiRetrofit") retrofit:Retrofit):UserService = retrofit.create(UserService::class.java)
}