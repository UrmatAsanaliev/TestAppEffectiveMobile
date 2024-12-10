package com.x.domain.usecases

import com.x.domain.repository.MainRepository

class GetOffersUseCase(
    private val repo: MainRepository
) {

    operator fun invoke() = repo.getOffers()

}