package com.example.navigacodechallenge.viewmodel.impl

import com.example.navigacodechallenge.service.ServiceModule
import com.example.navigacodechallenge.service.ItemService
import com.example.navigacodechallenge.viewmodel.ItemViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(
    includes = [ServiceModule::class]
)
class ViewModelModule {
    @Provides
    @Singleton
    fun provideTypicodeViewModel(itemService: ItemService) : ItemViewModel {
        return ItemViewModelImpl(itemService)
    }
}