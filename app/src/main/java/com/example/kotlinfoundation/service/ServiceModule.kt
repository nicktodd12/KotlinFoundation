package com.example.kotlinfoundation.service

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ServiceModule {
    @Provides
    @Singleton
    fun provideTypicodeService() : TypicodeService {
        return ServiceFactory.createService(TypicodeService::class.java)
    }
}