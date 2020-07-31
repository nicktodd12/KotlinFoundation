package com.example.kotlinfoundation.application

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class KotlinFoundationApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<KotlinFoundationApplication> {
        return DaggerAppComponent.builder().create(this)
    }
}