package com.homeandroid.weather

import android.app.Application
import com.homeandroid.weather.di.applicationModule
import com.homeandroid.weather.di.viewModelsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class BaseApplication:Application(){


    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@BaseApplication)
            modules(applicationModule,viewModelsModule)
        }
    }

}