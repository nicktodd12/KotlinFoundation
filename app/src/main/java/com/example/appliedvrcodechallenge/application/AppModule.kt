package com.example.appliedvrcodechallenge.application

import android.content.Context
import com.example.appliedvrcodechallenge.viewmodel.impl.ViewModelModule
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
        return AppliedVRCodeChallengeApplication.applicationContext()
    }
}