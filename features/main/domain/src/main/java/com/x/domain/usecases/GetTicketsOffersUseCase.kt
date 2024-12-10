package com.x.domain.usecases

import com.x.domain.repository.MainRepository

class GetTicketsOffersUseCase(
    private val repo: MainRepository
) {

    operator fun invoke() = repo.getTicketsOffers()
}