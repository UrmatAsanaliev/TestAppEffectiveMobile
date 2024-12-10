package com.x.data.remote.dtos

import com.google.gson.annotations.SerializedName
import com.x.data.mapper.DataMapper
import com.x.domain.model.ArrivalModel
import com.x.domain.model.DepartureModel
import com.x.domain.model.HandLuggageModel
import com.x.domain.model.LuggageModel
import com.x.domain.model.TicketsModel

data class Tickets(
    val tickets: List<TicketsDto>
)


data class TicketsDto(
    val id: Int,
    val badge: String? = null,
    val price: PriceDto,
    val providerName: String? = null,
    val company: String,
    val departure: DepartureDto,
    val arrival: ArrivalDto,
    @SerializedName("has_transfer")
    val hasTransfer: Boolean,
    @SerializedName("has_visa_transfer")
    val hasVisaTransfer: Boolean,
    val luggage: LuggageDto,
    @SerializedName("hand_luggage")
    val handLuggage: HandLuggageDto,
    @SerializedName("is_returnable")
    val isReturnable: Boolean,
    @SerializedName("is_exchangable")
    val isExchangable: Boolean
): DataMapper<TicketsModel> {
    override fun toDomain() =
        TicketsModel(
            id = id,
            badge = badge,
            price = price.toDomain(),
            providerName = providerName,
            company = company,
            departure = departure.toDomain(),
            arrival = arrival.toDomain(),
            hasTransfer = hasTransfer,
            hasVisaTransfer = hasVisaTransfer,
            luggage = luggage.toDomain(),
            handLuggage = handLuggage.toDomain(),
            isReturnable = isReturnable,
            isExchangable = isExchangable
        )
}

data class DepartureDto(
    val town: String,
    val date: String,
    val airport: String
): DataMapper<DepartureModel> {
    override fun toDomain() = DepartureModel(
        town = town,
        date = date,
        airport = airport
    )
}

data class ArrivalDto(
    val town: String,
    val date: String,
    val airport: String
): DataMapper<ArrivalModel> {
    override fun toDomain() =
        ArrivalModel(
            town = town,
            date = date,
            airport = airport
        )
}

data class LuggageDto(
    @SerializedName("has_luggage")
    val hasLuggage: Boolean,
    val price: PriceDto? = null
): DataMapper<LuggageModel> {
    override fun toDomain() =
        LuggageModel(
            hasLuggage = hasLuggage,
            price = price?.toDomain()
        )
}

data class HandLuggageDto(
    @SerializedName("has_hand_luggage")
    val hasHandLuggage: Boolean,
    val size: String? = null
): DataMapper<HandLuggageModel> {
    override fun toDomain() =
        HandLuggageModel(
            hasHandLuggage = hasHandLuggage,
            size = size
        )
}
