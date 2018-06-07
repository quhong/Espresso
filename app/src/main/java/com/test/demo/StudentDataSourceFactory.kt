package com.test.demo

import android.arch.lifecycle.MutableLiveData
import android.arch.paging.DataSource
import com.test.demo.db.SchoolDatabase
import com.test.demo.db.Student

class StudentDataSourceFactory(private val database: SchoolDatabase): DataSource.Factory<String, Student>() {

    val sourceLiveData = MutableLiveData<StudentDataSource>()

    override fun create(): DataSource<String, Student> {
        val source = StudentDataSource(database)
        sourceLiveData.postValue(source)
        return source
    }
}