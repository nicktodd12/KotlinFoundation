package com.example.kotlinfoundation.application

import com.example.kotlinfoundation.activity.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class ActivityAndFragmentModule {
    @ContributesAndroidInjector
    abstract fun mainActivity(): MainActivity
}