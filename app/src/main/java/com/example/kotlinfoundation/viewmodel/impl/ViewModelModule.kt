package com.example.kotlinfoundation.viewmodel.impl

import com.example.kotlinfoundation.service.ServiceModule
import com.example.kotlinfoundation.service.TypicodeService
import com.example.kotlinfoundation.viewmodel.TypicodeViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(
    includes = [ServiceModule::class]
)
class ViewModelModule {
    @Provides
    @Singleton
    fun provideTypicodeViewModel(typicodeService: TypicodeService) : TypicodeViewModel {
        return TypicodeViewModelImpl(typicodeService)
    }
}