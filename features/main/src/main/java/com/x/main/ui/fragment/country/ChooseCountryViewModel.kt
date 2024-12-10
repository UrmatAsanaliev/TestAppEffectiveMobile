package com.x.main.ui.fragment.country

import com.x.core.base.BaseViewModel
import com.x.domain.usecases.GetTicketsOffersUseCase
import com.x.main.model.TicketsOffersUI
import com.x.main.model.toUI
import kotlinx.coroutines.flow.asStateFlow

class ChooseCountryViewModel(
    private val getTicketsOffersUseCase: GetTicketsOffersUseCase
): BaseViewModel() {

    private val _ticketsOffers = mutableUIStateFlow<List<TicketsOffersUI>>()
    val ticketsOffers = _ticketsOffers.asStateFlow()


    fun getTicketsOffers() =
        getTicketsOffersUseCase().gatherRequest(_ticketsOffers) { ticketsOffers ->
            ticketsOffers.map {
                it.toUI()
            }
        }
}