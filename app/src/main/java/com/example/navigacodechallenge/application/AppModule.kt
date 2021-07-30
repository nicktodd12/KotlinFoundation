package com.example.navigacodechallenge.application

import android.content.Context
import com.example.navigacodechallenge.viewmodel.impl.ViewModelModule
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * App wide items used for injection
 */
@Module(includes = [ViewModelModule::class])
class AppModule {
    @Provides
    @Singleton
    fun context() : Context {
        return NavigaCodeChallengeApplication.applicationContext()
    }
}