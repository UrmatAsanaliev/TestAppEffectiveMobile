package com.x.data.network.module

import android.content.Context
import android.content.SharedPreferences
import com.x.data.network.repo.SharedRepositoryImpl
import com.x.domain.network.repo.SharedRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val sharedModule = module {
    single<SharedPreferences> {
        androidContext().getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
    }

    single<SharedRepository> {
        SharedRepositoryImpl(get())
    }
}