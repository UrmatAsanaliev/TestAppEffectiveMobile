package com.x.domain.network.usecases

import com.x.domain.network.repo.SharedRepository

class GetCityUseCase(
    private val shared: SharedRepository
) {
    operator fun invoke() = shared.getCity()
}