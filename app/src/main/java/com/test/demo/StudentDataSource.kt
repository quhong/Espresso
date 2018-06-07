package com.test.demo

import android.arch.lifecycle.MutableLiveData
import android.arch.paging.ItemKeyedDataSource
import com.test.demo.db.SchoolDatabase
import com.test.demo.db.Student
import timber.log.Timber

/**
 *
 * Created by quhong on 2018/6/6.
 */
class StudentDataSource(database: SchoolDatabase) : ItemKeyedDataSource<String, Student>() {

    private val studentDao = database.studentDao()

    val initialLoad by lazy {
        MutableLiveData<Resource<String>>()
    }

    override fun loadInitial(params: LoadInitialParams<String>, callback: LoadInitialCallback<Student>) {
        Timber.i("initial ${params.requestedLoadSize}")
        initialLoad.postValue(Resource.loading(null))
        val load = load(params.requestedLoadSize)
        initialLoad.postValue(Resource.success(null))
        start += load.size
        callback.onResult(load)
    }

    override fun loadAfter(params: LoadParams<String>, callback: LoadCallback<Student>) {
        Timber.i("after ${params.requestedLoadSize}")
        initialLoad.postValue(Resource.loading(null))
        val load = load(params.requestedLoadSize)
        initialLoad.postValue(Resource.success(null))
        start += load.size
        callback.onResult(load)
    }

    override fun loadBefore(params: LoadParams<String>, callback: LoadCallback<Student>) {
        Timber.i("before ${params.requestedLoadSize}")
    }

    override fun getKey(item: Student): String {
        return item.name
    }

    var start: Int = 0

    fun load(limit: Int): List<Student> {
        return studentDao.students(limit, start)
    }

}