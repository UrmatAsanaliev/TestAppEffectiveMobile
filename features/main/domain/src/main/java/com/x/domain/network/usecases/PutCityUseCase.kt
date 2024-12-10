package com.x.domain.network.usecases

import com.x.domain.network.repo.SharedRepository

class PutCityUseCase(
    private val shared: SharedRepository
) {
    operator fun invoke(city: String) {
        shared.putCity(city = city)
    }
}