package com.sh3h.citymanager.di

import android.content.Context
import com.sh3h.citymanager.runner.TestApplication
import dagger.Binds
import dagger.Module

/**
 *
 * Created by quhong on 2018/4/8.
 */
@Module
interface TestAppModule {

    @Binds
    fun bindContext(application: TestApplication): Context

}