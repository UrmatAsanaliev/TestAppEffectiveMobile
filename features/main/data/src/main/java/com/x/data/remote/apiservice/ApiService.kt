package com.x.data.remote.apiservice

import com.x.data.BuildConfig.OFFERS_API_KEY
import com.x.data.BuildConfig.TICKETS_OFFERS_API_KEY
import com.x.data.remote.dtos.Offers
import com.x.data.remote.dtos.TicketsOffers
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("uc")
    suspend fun getOffers(
        @Query("id") id: String = OFFERS_API_KEY,
        @Query("export") export: String = "download"
    ): Offers

    @GET("uc")
    suspend fun getTicketsOffers(
        @Query("id") id: String = TICKETS_OFFERS_API_KEY,
        @Query("export") export: String = "download"
    ): TicketsOffers

}