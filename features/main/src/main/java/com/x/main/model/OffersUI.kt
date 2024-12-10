package com.x.main.model

import com.x.domain.model.OffersModel


data class OffersUI(
    val id: Int,
    val title: String,
    val town: String,
    val price: PriceUI
)

fun OffersModel.toUI() = OffersUI(
    id = id,
    title = title,
    town = town,
    price = price.toUI()
)
