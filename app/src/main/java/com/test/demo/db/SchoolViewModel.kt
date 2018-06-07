package com.test.demo.db

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Transformations
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import com.test.demo.Resource
import com.test.demo.StudentDataSourceFactory
import timber.log.Timber

/**
 *
 * Created by quhong on 2018/6/6.
 */
class SchoolViewModel(application: Application) : AndroidViewModel(application) {

    private val mPagingConfig = PagedList.Config.Builder()
            .setPageSize(20)
            .setPrefetchDistance(20 * 2)
            .setEnablePlaceholders(true)
            .build()!!

    val sourceFactory = StudentDataSourceFactory(SchoolDatabase.getInstance(application))

    val pagerList = LivePagedListBuilder(sourceFactory, mPagingConfig)
            .build()

    val refreshState: LiveData<Resource<String>> = Transformations.switchMap(sourceFactory.sourceLiveData) {
        Timber.i("in")
        it.initialLoad
    }

    fun refresh(){
        sourceFactory.sourceLiveData.value?.invalidate()
    }

}