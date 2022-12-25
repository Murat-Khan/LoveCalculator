package com.murat.lovecalculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import com.murat.lovecalculator.databinding.FragmentHomeBinding
import com.murat.lovecalculator.databinding.FragmentResultBinding


class ResultFragment : Fragment() {

    lateinit var binding: FragmentResultBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResultBinding.inflate(inflater,container,false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setData()
        initClicker()
    }

    private fun initClicker() {
       binding.btnTryAgain.setOnClickListener {
           findNavController().navigateUp()
       }
    }

    private fun setData() {
        val loveModel:LoveModel = arguments?.getSerializable("key") as LoveModel
        binding.tvFirstName.text = loveModel.fistName
        binding.tvSecondName.text = loveModel.secondName
        binding.tvResult.text = loveModel.result
        binding.percentage.text = loveModel.percentage
    }


}