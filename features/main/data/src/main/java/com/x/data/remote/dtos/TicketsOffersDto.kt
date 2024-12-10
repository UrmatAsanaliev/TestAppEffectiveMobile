package com.x.data.remote.dtos

import com.google.gson.annotations.SerializedName
import com.x.data.mapper.DataMapper
import com.x.domain.model.PriceModel
import com.x.domain.model.TicketsOffersModel

data class TicketsOffers(
    val tickets_offers: List<TicketsOffersDto>
)


data class TicketsOffersDto(
    val id: Int,
    val title: String,
    @SerializedName("time_range")
    val timeRange: List<String>,
    val price: PriceDto
): DataMapper<TicketsOffersModel> {
    override fun toDomain() =
        TicketsOffersModel(
            id = id,
            title = title,
            timeRange = timeRange,
            price = price.toDomain()
        )
}

data class PriceDto(
    val value: Int
): DataMapper<PriceModel> {
    override fun toDomain() = PriceModel(
        value = value
    )
}