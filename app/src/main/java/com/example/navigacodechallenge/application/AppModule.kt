package com.example.navigacodechallenge.application

import android.content.Context
import com.example.navigacodechallenge.viewmodel.impl.ViewModelModule
import com.squareup.picasso.OkHttpDownloader
import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
class AppModule {
    @Provides
    @Singleton
    fun context() : Context {
        return NavigaCodeChallengeApplication.applicationContext()
    }

    @Provides
    @Singleton
    fun picasso(context: Context) : Picasso {
        val builder = Picasso.Builder(context)
        builder.downloader(OkHttpDownloader(context))
        return builder.build()
    }
}