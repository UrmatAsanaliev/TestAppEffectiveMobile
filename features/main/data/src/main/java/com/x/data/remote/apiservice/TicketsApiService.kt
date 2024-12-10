package com.x.data.remote.apiservice

import com.x.data.BuildConfig.TICKETS_API_KEY
import com.x.data.remote.dtos.Tickets
import retrofit2.http.GET
import retrofit2.http.Query

interface TicketsApiService {


    @GET("uc")
    suspend fun getTickets(
        @Query("export") export: String = "download",
        @Query("id") id: String = TICKETS_API_KEY
    ): Tickets
}