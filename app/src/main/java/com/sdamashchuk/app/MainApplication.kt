package com.sdamashchuk.app

import android.app.Application
import com.sdamashchuk.data.di.dataModules
import com.sdamashchuk.domain.di.domainModules
import com.sdamashchuk.cocktaillist.di.cocktailListModule
import com.sdamashchuk.cocktaildetails.di.cocktailDetailsModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MainApplication : Application() {

    override fun onCreate() {
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@MainApplication)
            modules(cocktailListModule, cocktailDetailsModule)
            modules(domainModules)
            modules(dataModules)
        }
        super.onCreate()
    }
}