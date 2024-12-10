package com.x.main.ui.fragment.ticket

import com.x.core.base.BaseViewModel
import com.x.domain.usecases.GetTicketsUseCase
import com.x.main.model.TicketsUI
import com.x.main.model.toUI
import kotlinx.coroutines.flow.asStateFlow

class TicketViewModel(
    private val getTicketsUseCase: GetTicketsUseCase,
): BaseViewModel() {

    private val _tickets = mutableUIStateFlow<List<TicketsUI>>()
    val tickets = _tickets.asStateFlow()

    fun getTickets() =
        getTicketsUseCase().gatherRequest(_tickets) { tickets ->
            tickets.map { it.toUI() }
        }


}