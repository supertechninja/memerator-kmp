package com.myapplication

import android.app.Application
import com.myapplication.di.appModule
import di.initKoin
import org.koin.android.ext.koin.androidContext

class MemeratorApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin {
            // https://github.com/InsertKoinIO/koin/issues/1188
            androidContext(this@MemeratorApplication)
            modules(appModule)
        }
    }
}