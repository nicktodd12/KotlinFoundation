package com.example.kotlinfoundation.application

import com.example.kotlinfoundation.viewmodel.impl.ViewModelModule
import dagger.Module

@Module(includes = [ViewModelModule::class])
class AppModule {
}