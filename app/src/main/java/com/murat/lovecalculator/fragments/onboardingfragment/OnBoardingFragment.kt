package com.murat.lovecalculator.fragments.onboardingfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.murat.lovecalculator.databinding.FragmentOnBoardingBinding
import com.murat.lovecalculator.fragments.onboardingfragment.adapter.OnBoardingAdapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class OnBoardingFragment : Fragment() {

    private val viewModel: OnBoardingViewModel by viewModels()
    lateinit var binding: FragmentOnBoardingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnBoardingBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = OnBoardingAdapter()
        binding.viewPager.adapter = adapter
        binding.indicator.setViewPager(binding.viewPager)
        adapter.registerAdapterDataObserver(binding.indicator.adapterDataObserver)

        binding.btnStarted.setOnClickListener {
            viewModel.setFirstStart(false)
            findNavController().navigateUp()
        }

        binding.skip.setOnClickListener {
            viewModel.setFirstStart(false)
            findNavController().navigateUp()

        }


        binding.viewPager.registerOnPageChangeCallback(object : OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding.btnStarted.isVisible = position == adapter.itemCount - 1
                binding.skip.isVisible = position != adapter.itemCount - 1
            }
        })


    }


}