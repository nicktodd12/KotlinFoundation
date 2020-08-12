package com.example.navigacodechallenge.application

import com.example.navigacodechallenge.activity.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class ActivityAndFragmentModule {
    @ContributesAndroidInjector
    abstract fun mainActivity(): MainActivity
}