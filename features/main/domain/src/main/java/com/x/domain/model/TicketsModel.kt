package com.x.domain.model

data class TicketsModel(
    val id: Int,
    val badge: String? = null,
    val price: PriceModel,
    val providerName: String? = null,
    val company: String,
    val departure: DepartureModel,
    val arrival: ArrivalModel,
    val hasTransfer: Boolean,
    val hasVisaTransfer: Boolean,
    val luggage: LuggageModel,
    val handLuggage: HandLuggageModel,
    val isReturnable: Boolean,
    val isExchangable: Boolean
)

data class DepartureModel(
    val town: String,
    val date: String,
    val airport: String
)

data class ArrivalModel(
    val town: String,
    val date: String,
    val airport: String
)

data class LuggageModel(
    val hasLuggage: Boolean,
    val price: PriceModel? = null
)

data class HandLuggageModel(
    val hasHandLuggage: Boolean,
    val size: String? = null
)