package com.example.kotlinfoundation.application

import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        ActivityAndFragmentModule::class
    ]
)
interface AppComponent : AndroidInjector<KotlinFoundationApplication> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<KotlinFoundationApplication>()
}