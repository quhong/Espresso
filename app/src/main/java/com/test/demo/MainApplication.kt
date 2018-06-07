package com.test.demo

import android.app.Application
import timber.log.Timber

/**
 *
 * Created by quhong on 2018/6/6.
 */
class MainApplication : Application() {


    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}