package com.test.demo.runner;

import android.app.Application;
import android.content.Context;
import android.support.test.runner.AndroidJUnitRunner;

import com.test.demo.TestApplication;

public class MyRunner extends AndroidJUnitRunner {


    @Override
    public Application newApplication(ClassLoader cl,
                                      String className,
                                      Context context) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return super.newApplication(cl, TestApplication.class.getName(), context);
    }
}
