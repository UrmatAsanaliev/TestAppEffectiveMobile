package com.x.domain.model

data class OffersModel(
    val id: Int,
    val title: String,
    val town: String,
    val price: PriceModel
)