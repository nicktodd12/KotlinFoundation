package com.example.appliedvrcodechallenge.application

import com.example.appliedvrcodechallenge.activity.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Module for holding any activities or fragments which use injection
 */
@Module
internal abstract class ActivityAndFragmentModule {
    @ContributesAndroidInjector
    abstract fun mainActivity(): MainActivity
}