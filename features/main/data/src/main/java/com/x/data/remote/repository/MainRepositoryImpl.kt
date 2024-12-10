package com.x.data.remote.repository

import android.util.Log
import com.x.common.Either
import com.x.data.base.makeNetworkRequest
import com.x.data.remote.apiservice.ApiService
import com.x.data.remote.apiservice.TicketsApiService
import com.x.domain.model.OffersModel
import com.x.domain.model.TicketsModel
import com.x.domain.model.TicketsOffersModel
import com.x.domain.repository.MainRepository
import kotlinx.coroutines.flow.Flow

class MainRepositoryImpl(
    private val apiService: ApiService,
    private val service: TicketsApiService
): MainRepository {

    override fun getTickets(): Flow<Either<String, List<TicketsModel>>> =
        makeNetworkRequest {
            service.getTickets().tickets.map { it.toDomain() }
        }

    override fun getTicketsOffers(): Flow<Either<String, List<TicketsOffersModel>>> =
        makeNetworkRequest {
            apiService.getTicketsOffers().tickets_offers.map { it.toDomain() }
        }

    override fun getOffers(): Flow<Either<String, List<OffersModel>>> =
        makeNetworkRequest {
            apiService.getOffers().offers.map { it.toDomain() }
        }
}