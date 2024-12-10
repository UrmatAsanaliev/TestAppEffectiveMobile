package com.x.main.model

import com.x.data.mapper.DataMapper
import com.x.domain.model.PriceModel
import com.x.domain.model.TicketsOffersModel

data class TicketsOffersUI(
    val id: Int,
    val title: String,
    val timeRange: List<String>,
    val price: PriceUI
)

fun TicketsOffersModel.toUI() = TicketsOffersUI(
    id = id,
    title = title,
    timeRange = timeRange,
    price = price.toUI()
)

data class PriceUI(
    val value: Int
)

fun PriceModel.toUI() = PriceUI(
    value = value
)