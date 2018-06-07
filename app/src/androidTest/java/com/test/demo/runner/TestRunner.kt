package com.test.demo.runner

import android.app.Application
import android.content.Context
import android.support.test.runner.AndroidJUnitRunner
import com.test.demo.ApplicationTest

/**
 *
 * Created by quhong on 2018/4/10.
 */
class TestRunner : AndroidJUnitRunner() {


    override fun newApplication(cl: ClassLoader?, className: String?, context: Context?): Application {
        return super.newApplication(cl, ApplicationTest::class.java.name, context)
    }
}