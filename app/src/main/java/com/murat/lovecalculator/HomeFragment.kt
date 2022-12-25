package com.murat.lovecalculator

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.murat.lovecalculator.databinding.FragmentHomeBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeFragment : Fragment() {

lateinit var binding: FragmentHomeBinding
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
           btnCalculate.setOnClickListener { RetrofitService().getApi().getResultLove(
               fistName = firstName.text.toString(),
           secondName = secondName.text.toString(),

           ).enqueue(object :Callback<LoveModel>{
               override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                   if (response.isSuccessful){
                       val loveModel = response.body()
                       val bundle = Bundle()
                     bundle.putSerializable("key",loveModel)
                       findNavController().navigate(R.id.resultFragment,bundle )
                       firstName.text?.clear()
                       secondName.text?.clear()

                   }
               }

               override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                   Log.e("raya","${t.message}")
               }
           }) }

       }
    }

}