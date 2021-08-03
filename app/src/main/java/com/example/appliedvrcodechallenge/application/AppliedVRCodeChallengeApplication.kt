package com.example.appliedvrcodechallenge.application

import android.content.Context
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

/**
 * Implementation of the Dagger application
 */
class AppliedVRCodeChallengeApplication : DaggerApplication() {

    init {
        instance = this
    }

    override fun applicationInjector(): AndroidInjector<AppliedVRCodeChallengeApplication> {
        return DaggerAppComponent.builder().create(this)
    }

    companion object {
        private var instance: AppliedVRCodeChallengeApplication? = null

        fun applicationContext() : Context {
            return instance!!.applicationContext
        }
    }
}