package com.murat.lovecalculator.fragments.historyfragment

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Button
import android.widget.EditText
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.murat.lovecalculator.App
import com.murat.lovecalculator.R
import com.murat.lovecalculator.databinding.FragmentHistoryBinding
import com.murat.lovecalculator.remote.LoveModel
import com.murat.lovecalculator.repozitory.Repository
import com.murat.lovecalculator.room.LoveDataBase
import com.murat.lovecalculator.utils.Constants.KEY_FOR_UPDATE
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HistoryFragment : Fragment(), HistoryAdapter.OnItemClickListener {
    lateinit var binding: FragmentHistoryBinding
    lateinit var historyAdapter : HistoryAdapter
    @Inject
    lateinit var repository: Repository
    @Inject
    lateinit var db : LoveDataBase






    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHistoryBinding.inflate(inflater,container,false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        historyAdapter = HistoryAdapter(this)

        repository.getAllSort().observe(this@HistoryFragment.viewLifecycleOwner, Observer {

            historyAdapter.addAll(it as ArrayList<LoveModel>)
            binding.historyRecycler.adapter = historyAdapter

        /* it.forEach {loveModel ->
                binding.tvHistory.append("${loveModel.fistName} \n${loveModel.secondName} \n${loveModel.percentage} \n${loveModel.result} \n")
            }*/
        })
    }

    override fun onItemClick(model: LoveModel) {
        val dialogBinding = layoutInflater.inflate(R.layout.dialog, null)
        val myDialog = Dialog(requireContext())
        myDialog.setContentView(dialogBinding)
        myDialog.setCancelable(true)
        myDialog.window?.setBackgroundDrawable(ColorDrawable(Color.WHITE))
        val firstName = dialogBinding.findViewById<EditText>(R.id.etFirstName)
        val secondName = dialogBinding.findViewById<EditText>(R.id.etSecondName)
        firstName.setText(model.fistName)
        secondName.setText(model.secondName)


        val btnUpdate = dialogBinding.findViewById<Button>(R.id.btnUpdate)
        btnUpdate.setOnClickListener {
            db.getDao().update(fn = firstName.text.toString(),sn = secondName.text.toString(),id = model.id)



            myDialog.dismiss()}
        myDialog.show()
       // findNavController().navigate(R.id.homeFragment , bundleOf(KEY_FOR_UPDATE to model ))


    }
    private fun showLoginDialog() {

    }






}