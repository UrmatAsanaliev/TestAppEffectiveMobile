package com.x.main.module

import com.x.main.ui.fragment.country.ChooseCountryViewModel
import com.x.main.ui.fragment.main.MainViewModel
import com.x.main.ui.fragment.ticket.TicketViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel(get(), get(), get()) }
    viewModel { ChooseCountryViewModel(get()) }
    viewModel { TicketViewModel(get()) }
}