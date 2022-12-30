package com.murat.lovecalculator.fragments
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels

import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.murat.lovecalculator.R
import com.murat.lovecalculator.databinding.FragmentHomeBinding
import com.murat.lovecalculator.viewmodel.LoveViewModel



class HomeFragment : Fragment() {

lateinit var binding: FragmentHomeBinding
private val viewModel : LoveViewModel  by  viewModels()




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        // Inflate the layout for this fragment
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initClicker()



    }

    private fun initClicker() {
       with(binding){
           btnCalculate.setOnClickListener {
               viewModel.getLiveLoveModel(firstName.text.toString(),secondName.text.toString())
                   .observe(this@HomeFragment.viewLifecycleOwner, Observer {
                       val loveModel = it
                       findNavController().navigate(R.id.resultFragment, bundleOf("key" to loveModel))
                       firstName.text?.clear()
                       secondName.text?.clear()
                   })






           /*RetrofitService().getApi().getResultLove(
               fistName = firstName.text.toString(),
           secondName = secondName.text.toString(),

           ).enqueue(object :Callback<LoveModel>{
               override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                   if (response.isSuccessful){
                       val loveModel = response.body()
                       val extras = FragmentNavigatorExtras()
                       findNavController().navigate(R.id.resultFragment, bundleOf("key" to loveModel))
                       firstName.text?.clear()
                       secondName.text?.clear()
                   }
               }

               override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                   Log.e("raya","${t.message}")
               }
           })*/
           }
       }
    }
}