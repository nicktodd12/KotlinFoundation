package com.example.navigacodechallenge.application

import android.content.Context
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class NavigaCodeChallengeApplication : DaggerApplication() {

    init {
        instance = this
    }

    override fun applicationInjector(): AndroidInjector<NavigaCodeChallengeApplication> {
        return DaggerAppComponent.builder().create(this)
    }

    companion object {
        private var instance: NavigaCodeChallengeApplication? = null

        fun applicationContext() : Context {
            return instance!!.applicationContext
        }
    }
}