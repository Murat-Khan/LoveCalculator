package com.murat.lovecalculator.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.murat.lovecalculator.remote.LoveModel
import com.murat.lovecalculator.repozitory.Repository

class LoveViewModel : ViewModel() {

    private val repository = Repository()
    fun getLiveLoveModel(fistName : String,secondName : String) : LiveData<LoveModel>{
        return repository.getLiveLove(fistName,secondName)

    }
}