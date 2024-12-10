package com.x.main.ui.fragment.main_flow

import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.x.core.base.BaseFragmentWithoutViewModel
import com.x.main.R
import com.x.main.databinding.FragmentMainFlowBinding

class MainFlowFragment : BaseFragmentWithoutViewModel(R.layout.fragment_main_flow) {

    private val binding: FragmentMainFlowBinding by lazy {
        FragmentMainFlowBinding.inflate(layoutInflater)
    }

    private val controller: NavController by lazy {
        val navHostFragment =
            requireActivity().supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navHostFragment.navController
    }

    override fun initialize() {
        binding.navView.apply {
            setupWithNavController(controller)
        }
    }
}