package com.x.data.remote.dtos

import com.x.data.mapper.DataMapper
import com.x.domain.model.OffersModel

data class Offers(
    val offers: List<OffersDto>
)

data class OffersDto(
    val id: Int,
    val title: String,
    val town: String,
    val price: PriceDto
):DataMapper<OffersModel> {
    override fun toDomain() =
        OffersModel(
            id = id,
            title = title,
            town = town,
            price = price.toDomain()
        )
}