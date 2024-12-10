package com.x.domain.repository

import com.x.common.Either
import com.x.domain.model.OffersModel
import com.x.domain.model.TicketsModel
import com.x.domain.model.TicketsOffersModel
import kotlinx.coroutines.flow.Flow

interface MainRepository {

    fun getTickets(): Flow<Either<String, List<TicketsModel>>>

    fun getTicketsOffers(): Flow<Either<String, List<TicketsOffersModel>>>

    fun getOffers(): Flow<Either<String, List<OffersModel>>>

}