package com.example.navigacodechallenge.service

import com.example.navigacodechallenge.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

internal object ServiceFactory {
    @JvmStatic
    fun <T> createService(service: Class<T>): T {
        val logging = HttpLoggingInterceptor()

        if (BuildConfig.DEBUG) {
            logging.level = HttpLoggingInterceptor.Level.BODY
        } else {
            logging.level = HttpLoggingInterceptor.Level.NONE
        }

        val httpClientBuilder = OkHttpClient.Builder().addInterceptor(logging)
        val builder = Retrofit.Builder()
        builder.client(httpClientBuilder.build())
        builder.baseUrl("http://static.navigamobile.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
        return builder.build().create(service)
    }
}