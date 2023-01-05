package com.murat.lovecalculator.main


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
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

        if (viewModel.isFirstStart()) {
            navController.navigate(R.id.onBoardingFragment)
        } else {
            navController.navigate(R.id.homeFragment)
        }


    }
}