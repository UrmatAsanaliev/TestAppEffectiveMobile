package com.x.main.ui.fragment.main

import android.util.Log
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.x.core.base.BaseFragment
import com.x.core.ext.OnTextSelectedListener
import com.x.core.ext.doAfterTextChanged
import com.x.core.ext.gone
import com.x.core.ext.invisible
import com.x.core.ext.showBottomSheetOnFocus
import com.x.core.ext.visible
import com.x.main.R
import com.x.main.databinding.FragmentMainBinding
import com.x.main.ui.adapter.MusicAdapter
import com.x.main.ui.fragment.search.SearchFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment :
    BaseFragment<FragmentMainBinding, MainViewModel>(R.layout.fragment_main),
    OnTextSelectedListener {

    override val binding: FragmentMainBinding by viewBinding()
    override val viewModel: MainViewModel by viewModel()
    private val adapter: MusicAdapter by lazy { MusicAdapter() }


    override fun initialize() {
        binding.rvSearch.adapter = adapter
    }

    override fun launchObservers() {
        viewModel.getOffers()
        viewModel.offers.spectateUiState(
            success = { offers ->
                adapter.submitList(offers)
                binding.progressBar.gone()
                binding.rvSearch.visible()
            }, error = {
                Log.e("ololo", it)
            }, loading = {
                binding.progressBar.visible()
                binding.rvSearch.invisible()
            }
        )
    }

    override fun constructListeners() {
        binding.edFrom.setText(viewModel.getCity())

        binding.edFrom.doAfterTextChanged { city ->
            viewModel.putCity(city)
        }


        binding.edWhere.showBottomSheetOnFocus(requireActivity().supportFragmentManager) {
            SearchFragment(binding.edFrom.text.toString()).apply {
                setOnTextSelectedListener(it)
            }
        }

        binding.edWhere.setOnClickListener {
            val bottomSheetFragment = SearchFragment(from = binding.edFrom.text.toString())
            bottomSheetFragment.setOnTextSelectedListener(this)
            bottomSheetFragment.show(requireActivity().supportFragmentManager, "SearchFragment")

        }

        binding.edWhere.doAfterTextChanged { where ->
            if (where.isNotEmpty()) {
                showSearchCountryScreen()
            }
        }
    }

    private fun showSearchCountryScreen() {
        findNavController().navigate(
            MainFragmentDirections
                .actionMainFragmentToChooseCountryFragment()
                .setFrom(binding.edFrom.text.toString())
                .setWhere(binding.edWhere.text.toString())

        )
        binding.edWhere.text.clear()
    }

    override fun onTextSelected(from: String, where: String) {
        binding.edFrom.setText(from)
        binding.edWhere.setText(where)
        viewModel.putCity(from)
    }

}