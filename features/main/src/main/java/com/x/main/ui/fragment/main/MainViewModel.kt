package com.x.main.ui.fragment.main

import com.x.core.base.BaseViewModel
import com.x.domain.network.usecases.GetCityUseCase
import com.x.domain.network.usecases.PutCityUseCase
import com.x.domain.usecases.GetOffersUseCase
import com.x.main.model.OffersUI
import com.x.main.model.toUI
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel(
    private val getOffersUseCase: GetOffersUseCase,
    private val getCityUseCase: GetCityUseCase,
    private val putCityUseCase: PutCityUseCase
): BaseViewModel() {

    private val _offers = mutableUIStateFlow<List<OffersUI>>()
    val offers = _offers.asStateFlow()


    fun getOffers() =
        getOffersUseCase().gatherRequest(_offers) { offers -> offers.map { it.toUI() } }


    fun getCity() = getCityUseCase()

    fun putCity(city: String) {
        putCityUseCase(city = city)
    }

}