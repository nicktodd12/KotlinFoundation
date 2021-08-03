package com.example.appliedvrcodechallenge.application

import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Interface for combining all modules and setting up the application for injection
 */
@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        ActivityAndFragmentModule::class
    ]
)
interface AppComponent : AndroidInjector<AppliedVRCodeChallengeApplication> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<AppliedVRCodeChallengeApplication>()
}