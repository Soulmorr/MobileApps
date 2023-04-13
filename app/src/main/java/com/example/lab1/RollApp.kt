package com.example.lab1

import android.app.Application
import timber.log.Timber

class RollApp : Application() {
    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())
    }
}