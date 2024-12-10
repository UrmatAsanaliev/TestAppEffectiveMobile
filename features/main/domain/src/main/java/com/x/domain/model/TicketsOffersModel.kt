package com.x.domain.model

data class TicketsOffersModel(
    val id: Int,
    val title: String,
    val timeRange: List<String>,
    val price: PriceModel
)

data class PriceModel(
    val value: Int
)