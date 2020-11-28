package com.cahstudio.gallery

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import com.cahstudio.gallery.di.apiModule
import com.cahstudio.gallery.di.networkModule
import com.cahstudio.gallery.di.repositoryModule
import com.cahstudio.gallery.di.viewModelModule

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@BaseApplication)
            modules(listOf(viewModelModule, repositoryModule, apiModule, networkModule))
        }
    }
}