package com.x.domain.module

import com.x.domain.network.usecases.GetCityUseCase
import com.x.domain.network.usecases.PutCityUseCase
import com.x.domain.usecases.GetOffersUseCase
import com.x.domain.usecases.GetTicketsOffersUseCase
import com.x.domain.usecases.GetTicketsUseCase
import org.koin.dsl.module

val domainModule = module {
    factory { GetOffersUseCase(get()) }
    factory { GetTicketsUseCase(get()) }
    factory { GetTicketsOffersUseCase(get()) }
    factory { GetCityUseCase(get()) }
    factory { PutCityUseCase(get()) }
}