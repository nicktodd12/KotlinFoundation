package com.example.appliedvrcodechallenge.service

import android.content.Context
import com.example.appliedvrcodechallenge.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Creates a service of the specified type to be used when injecting the service
 */
internal object ServiceFactory {
    @JvmStatic
    fun <T> createService(service: Class<T>, context: Context): T {
        val logging = HttpLoggingInterceptor()

        if (BuildConfig.DEBUG) {
            logging.level = HttpLoggingInterceptor.Level.BODY
        } else {
            logging.level = HttpLoggingInterceptor.Level.NONE
        }

        val httpClientBuilder = OkHttpClient.Builder().addInterceptor(logging).addInterceptor(MockRequestInterceptor(context))
        val builder = Retrofit.Builder()
        builder.client(httpClientBuilder.build())
        builder.baseUrl("http://www.test.com")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
        return builder.build().create(service)
    }
}