package vn.musicstore.app.di.module

import android.content.Context
import com.squareup.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import javax.inject.Singleton

@Module
class PicassoModule {
    @Provides
    fun providesOkHttp3Downloader(okHttpClient: OkHttpClient) = OkHttp3Downloader(okHttpClient)

    @Provides
    fun providesPicasso(context: Context, okHttp3Downloader: OkHttp3Downloader) = Picasso.Builder(context)
            .downloader(okHttp3Downloader)
            .build()
}