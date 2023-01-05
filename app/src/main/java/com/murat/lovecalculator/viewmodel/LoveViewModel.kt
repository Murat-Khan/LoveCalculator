package com.murat.lovecalculator.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.murat.lovecalculator.remote.LoveModel
import com.murat.lovecalculator.repozitory.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class LoveViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    fun getLiveLoveModel(fistName : String,secondName : String) : LiveData<LoveModel>{
        return repository.getLiveLove(fistName,secondName)



    }
}