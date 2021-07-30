package com.example.navigacodechallenge.viewmodel.impl

import com.example.navigacodechallenge.service.FileService
import com.example.navigacodechallenge.service.ServiceModule
import com.example.navigacodechallenge.service.ItemService
import com.example.navigacodechallenge.viewmodel.FileViewModel
import com.example.navigacodechallenge.viewmodel.ItemViewModel
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
    fun provideItemViewModel(itemService: ItemService) : ItemViewModel {
        return ItemViewModelImpl(itemService)
    }

    @Provides
    @Singleton
    fun provideFileViewModel(fileService: FileService) : FileViewModel {
        return FileViewModelImpl(fileService)
    }
}