package com.example.appliedvrcodechallenge.viewmodel.impl

import com.example.appliedvrcodechallenge.service.FileService
import com.example.appliedvrcodechallenge.service.ServiceModule
import com.example.appliedvrcodechallenge.viewmodel.FileViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Module used for viewmodel injection
 */
@Module(
    includes = [ServiceModule::class]
)
class ViewModelModule {
    @Provides
    @Singleton
    fun provideFileViewModel(fileService: FileService) : FileViewModel {
        return FileViewModelImpl(fileService)
    }
}