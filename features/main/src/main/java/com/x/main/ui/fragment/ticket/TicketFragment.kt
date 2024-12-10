package com.x.main.ui.fragment.ticket

import android.annotation.SuppressLint
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.x.core.base.BaseFragment
import com.x.core.ext.gone
import com.x.core.ext.visible
import com.x.main.R
import com.x.main.databinding.FragmentTicketBinding
import com.x.main.ui.adapter.TicketAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

@RequiresApi(Build.VERSION_CODES.O)
class TicketFragment :
    BaseFragment<FragmentTicketBinding, TicketViewModel>(R.layout.fragment_ticket) {

    override val binding: FragmentTicketBinding by viewBinding()
    override val viewModel: TicketViewModel by viewModel()
    private val adapter: TicketAdapter by lazy { TicketAdapter() }

    @SuppressLint("SetTextI18n")
    override fun initialize() {
        binding.rvTickets.adapter = adapter

        val args = TicketFragmentArgs.fromBundle(requireArguments())

        binding.txtCities.text = "${args.from}-${args.where}"
        binding.txtDate.text = args.time
    }

    override fun launchObservers() {
        viewModel.getTickets()

        viewModel.tickets.spectateUiState(
            success = {
                adapter.submitList(it)
                binding.progressBar.gone()
                binding.rvTickets.visible()
                binding.card3.visible()
            }, error = {
                Log.e("ticket", it)
            }, loading = {
                binding.progressBar.visible()
                binding.rvTickets.gone()
                binding.card3.gone()
            }
        )
    }

    override fun constructListeners() {
        binding.imgBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }

}