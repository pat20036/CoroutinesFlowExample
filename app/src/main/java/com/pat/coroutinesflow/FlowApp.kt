package com.pat.coroutinesflow

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class FlowApp:Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin()
    }

    private fun startKoin()
    {
       startKoin {
           androidLogger()
           androidContext(this@FlowApp)
           modules(modules)
       }
    }
}