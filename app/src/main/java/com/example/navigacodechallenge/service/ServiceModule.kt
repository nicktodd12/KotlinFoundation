package com.example.navigacodechallenge.service

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Module which holds all services for injection
 */
@Module
class ServiceModule {
    @Provides
    @Singleton
    fun provideItemService(context: Context) : ItemService {
        return ServiceFactory.createService(ItemService::class.java, context)
    }

    @Provides
    @Singleton
    fun provideFileService(context: Context) : FileService {
        return ServiceFactory.createService(FileService::class.java, context)
    }
}