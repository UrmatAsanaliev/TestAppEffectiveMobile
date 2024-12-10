package com.x.main.model

import com.x.data.mapper.DataMapper
import com.x.domain.model.ArrivalModel
import com.x.domain.model.DepartureModel
import com.x.domain.model.HandLuggageModel
import com.x.domain.model.LuggageModel
import com.x.domain.model.TicketsModel

data class TicketsUI(
    val id: Int,
    val badge: String? = null,
    val price: PriceUI,
    val providerName: String? = null,
    val company: String,
    val departure: DepartureUI,
    val arrival: ArrivalUI,
    val hasTransfer: Boolean,
    val hasVisaTransfer: Boolean,
    val luggage: LuggageUI,
    val handLuggage: HandLuggageUI,
    val isReturnable: Boolean,
    val isExchangable: Boolean
)

fun TicketsModel.toUI() = TicketsUI(
    id = id,
    badge = badge,
    price = price.toUI(),
    providerName = providerName,
    company = company,
    departure = departure.toUI(),
    arrival = arrival.toUI(),
    hasTransfer = hasTransfer,
    hasVisaTransfer = hasVisaTransfer,
    luggage = luggage.toUI(),
    handLuggage = handLuggage.toUI(),
    isReturnable = isReturnable,
    isExchangable = isExchangable
)


data class DepartureUI(
    val town: String,
    val date: String,
    val airport: String
)

fun DepartureModel.toUI() = DepartureUI(
    town = town,
    date = date,
    airport = airport
)


data class ArrivalUI(
    val town: String,
    val date: String,
    val airport: String
)
fun ArrivalModel.toUI() = ArrivalUI(
    town = town,
    date = date,
    airport = airport
)



data class LuggageUI(
    val hasLuggage: Boolean,
    val price: PriceUI? = null
)

fun LuggageModel.toUI() = LuggageUI(
    hasLuggage = hasLuggage,
    price = price?.toUI()
)


data class HandLuggageUI(
    val hasHandLuggage: Boolean,
    val size: String? = null
)

fun HandLuggageModel.toUI() = HandLuggageUI(
    hasHandLuggage = hasHandLuggage,
    size = size
)
