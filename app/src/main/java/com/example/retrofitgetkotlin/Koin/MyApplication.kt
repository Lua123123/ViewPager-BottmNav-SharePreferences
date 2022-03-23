package com.example.retrofitgetkotlin.Koin

import android.app.Application
import com.example.retrofitgetkotlin.Koin.callApi
import com.example.retrofitgetkotlin.Koin.koinRepository
import com.example.retrofitgetkotlin.Koin.repositoryModule
import com.example.retrofitgetkotlin.Koin.viewModelModule
import org.koin.android.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(if (BuildConfig.DEBUG) org.koin.core.logger.Level.ERROR else org.koin.core.logger.Level.NONE)
            androidContext(this@MyApplication)
            modules(listOf(repositoryModule, callApi, koinRepository, viewModelModule, motorEngineer))
        }
    }
}