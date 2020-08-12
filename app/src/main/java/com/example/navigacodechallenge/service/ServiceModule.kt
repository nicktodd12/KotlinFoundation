package com.example.navigacodechallenge.service

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ServiceModule {
    @Provides
    @Singleton
    fun provideTypicodeService() : ItemService {
        return ServiceFactory.createService(ItemService::class.java)
    }
}