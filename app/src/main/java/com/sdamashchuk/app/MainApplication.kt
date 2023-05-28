package com.sdamashchuk.app

import android.app.Application
import com.sdamashchuk.data.di.dataModules
import com.sdamashchuk.domain.di.domainModules
import com.sdamashchuk.cocktaillist.di.cocktailListModule
import com.sdamashchuk.cocktaildetails.di.cocktailDetailsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        startKoin {
            androidContext(this@MainApplication)
            modules(cocktailListModule, cocktailDetailsModule)
            modules(domainModules)
            modules(dataModules)
        }
        super.onCreate()
    }
}