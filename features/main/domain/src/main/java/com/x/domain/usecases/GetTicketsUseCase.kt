package com.x.domain.usecases

import com.x.domain.repository.MainRepository

class GetTicketsUseCase(
    private val repo: MainRepository
) {

    operator fun invoke() = repo.getTickets()
}