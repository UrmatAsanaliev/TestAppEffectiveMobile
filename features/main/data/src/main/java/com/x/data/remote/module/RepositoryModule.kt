package com.x.data.remote.module

import com.x.data.remote.repository.MainRepositoryImpl
import com.x.domain.repository.MainRepository
import org.koin.dsl.module

val repoModule = module {
    single<MainRepository> { MainRepositoryImpl(get(), get()) }
}