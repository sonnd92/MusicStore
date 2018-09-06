package vn.musicstore.app.di.module

import android.content.Context
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.*
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import vn.musicstore.app.prefs.UserSaved
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
class NetworkModule {
    private val NET_WORK_TIME_OUT = 1 * 60L
    private val CACHE_SIZE = 10 * 1024 * 1024L

    @Singleton
    @Provides
    fun providesOkHttpClient(userSaved: UserSaved): OkHttpClient {
        val okHttpClientBuilder = OkHttpClient.Builder()
        okHttpClientBuilder.addInterceptor { chain ->
            val request = chain.request()
                    ?.newBuilder()
                    ?.addHeader("Authorization", userSaved.getTokenKey())
                    ?.build()

            chain.proceed(request)
        }
        okHttpClientBuilder.connectTimeout(NET_WORK_TIME_OUT, TimeUnit.MILLISECONDS)
        okHttpClientBuilder.readTimeout(NET_WORK_TIME_OUT, TimeUnit.MILLISECONDS)
        okHttpClientBuilder.writeTimeout(NET_WORK_TIME_OUT, TimeUnit.MILLISECONDS)

        return okHttpClientBuilder.build()
    }

    @Singleton
    @Provides
    fun providesGson(): Gson = GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create()

    @Singleton
    @Provides
    fun providesCache(context: Context) = Cache(context.externalCacheDir, CACHE_SIZE)

    @Singleton
    @Provides
    fun providesRetrofitBuilder(okHttpClient: OkHttpClient) = Retrofit
            .Builder()
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .client(okHttpClient)

    @Singleton
    @Provides
    @Named("ServerApiRetrofit")
    fun providesRetrofit(retrofitBuilder: Retrofit.Builder, gson: Gson) = retrofitBuilder
            .baseUrl("http://api.cisum.vn/api/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
}