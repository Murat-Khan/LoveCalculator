package com.murat.lovecalculator.main


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import com.murat.lovecalculator.R
import com.murat.lovecalculator.databinding.ActivityMainBinding

import com.murat.lovecalculator.local.Pref
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var viewModel: MainActivityViewModel

    // private val navController = NavController(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]
        setContentView(binding.root)
        val navController = findNavController(R.id.nav_host_fragment)
        binding.btnHistory.setOnClickListener {

            navController.navigate(R.id.historyFragment)



        }
        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            binding.btnHistory.isVisible = destination.id != R.id.historyFragment
        }

        if (viewModel.isFirstStart()) {
            navController.navigate(R.id.onBoardingFragment)
        } else {
            navController.navigate(R.id.homeFragment)
        }


    }
}