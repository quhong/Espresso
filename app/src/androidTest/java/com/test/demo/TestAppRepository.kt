package com.sh3h.citymanager.di

import android.app.Application
import com.sh3h.citymanager.data.AppRepository
import com.sh3h.dataprovider.AppDatabase
import com.sh3h.dataprovider.AppExecutors
import com.sh3h.dataprovider.DiskIOThreadExecutor
import com.sh3h.datautils.ServerData
import com.sh3h.datautils.UserSession
import dagger.Module
import dagger.Provides
import org.mockito.Mockito.mock
import java.util.concurrent.Executors
import javax.inject.Singleton

/**
 *
 * Created by quhong on 2018/4/8.
 */
@Module
object TestAppRepository {

    private const val THREAD_COUNT = 3

    @Provides
    @JvmStatic
    @Singleton
    fun provideAppRepository(): AppRepository {
        return mock(AppRepository::class.java)
    }

    @Singleton
    @JvmStatic
    @Provides
    fun providePref(): UserSession {
        return mock(UserSession::class.java)
    }

    @Singleton
    @JvmStatic
    @Provides
    fun provideDb(context: Application): AppDatabase {
        return AppDatabase.getAppDatabase(context, "main_test.cbj")
    }


    @Singleton
    @JvmStatic
    @Provides
    fun provideAppExecutors(): AppExecutors {
        return AppExecutors(DiskIOThreadExecutor(),
                Executors.newFixedThreadPool(THREAD_COUNT),
                AppExecutors.MainThreadExecutor())
    }

    @Singleton
    @JvmStatic
    @Provides
    fun provideServerData(): ServerData {
        return mock(ServerData::class.java)
    }

}