package com.x.main.ui.fragment.country

import android.util.Log
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.x.core.base.BaseFragment
import com.x.core.ext.gone
import com.x.core.ext.invisible
import com.x.core.ext.showDatePicker
import com.x.core.ext.visible
import com.x.main.R
import com.x.main.databinding.FragmentChooseCountryBinding
import com.x.main.ui.adapter.WaysAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class ChooseCountryFragment :
    BaseFragment<
            FragmentChooseCountryBinding,
            ChooseCountryViewModel>(R.layout.fragment_choose_country) {
    override val binding: FragmentChooseCountryBinding by viewBinding(FragmentChooseCountryBinding::bind)
    override val viewModel: ChooseCountryViewModel by viewModel()
    private val adapter: WaysAdapter by lazy { WaysAdapter() }

    override fun initialize() {
        val arg = ChooseCountryFragmentArgs.fromBundle(requireArguments())
        binding.edFrom.setText(arg.from)
        binding.edWhere.setText(arg.where)
        binding.rvTickets.adapter = adapter
    }

    override fun constructListeners() {
        binding.imgChange.setOnClickListener {
            val from = binding.edFrom.text.toString()
            val where = binding.edWhere.text.toString()

            binding.edFrom.setText(where)
            binding.edWhere.setText(from)
        }


        binding.imgClear.setOnClickListener {
            binding.edWhere.text.clear()
        }

        binding.backDate.showDatePicker {
            binding.txtBack.text = it
        }

        binding.date.showDatePicker {
            binding.txtDate.text = it
        }

        binding.imgBack.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.btnAllTickets.setOnClickListener {
            findNavController().navigate(
                ChooseCountryFragmentDirections
                    .actionChooseCountryFragmentToTicketFragment()
                    .setFrom(binding.edFrom.text.toString())
                    .setWhere(binding.edWhere.text.toString())
                    .setTime(binding.txtDate.text.toString())
            )
        }
    }

    override fun launchObservers() {
        viewModel.getTicketsOffers()

        viewModel.ticketsOffers.spectateUiState(
            success = { tickets ->
                adapter.submitList(tickets)
                binding.progressBar.gone()
                binding.rvTickets.visible()
            }, error = {
                Log.e("chooseCountry", it)
            }, loading = {
                binding.progressBar.visible()
                binding.rvTickets.invisible()
            }
        )
    }


}