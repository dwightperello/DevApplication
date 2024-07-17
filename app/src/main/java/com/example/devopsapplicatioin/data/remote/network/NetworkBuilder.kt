package com.example.devopsapplicatioin.data.remote.network

import com.microsoft.appcenter.BuildConfig
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit

object NetworkBuilder {
    private const val NETWORK_CALL_TIMEOUT = 60L

    fun create(baseURl: String, cacheDir: File, cacheSize: Long): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseURl)
            .client(okHttpClint(cacheDir, cacheSize))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        // .create(APIservice::class.java)
    }

    private fun okHttpClint(cacheDir: File, cacheSize: Long): OkHttpClient {
        return OkHttpClient.Builder()
            .cache(Cache(cacheDir, cacheSize))
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    level =
                        if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
                }
            )
            .readTimeout(NETWORK_CALL_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(NETWORK_CALL_TIMEOUT, TimeUnit.SECONDS)
            .build()
    }

    inline fun <reified T>provideAPICalls(retrofit: Retrofit):T{
        return retrofit.create(T::class.java)
    }
}