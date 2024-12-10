package com.x.testapp

import android.app.Application
import com.x.data.network.module.sharedModule
import com.x.data.remote.module.networkModule
import com.x.data.remote.module.repoModule
import com.x.domain.module.domainModule
import com.x.main.module.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(networkModule, repoModule, domainModule, viewModelModule, sharedModule)
        }
    }
}