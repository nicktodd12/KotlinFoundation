package com.example.navigacodechallenge.viewmodel.impl

import com.example.navigacodechallenge.service.FileService
import com.example.navigacodechallenge.service.ServiceModule
import com.example.navigacodechallenge.viewmodel.FileViewModel
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