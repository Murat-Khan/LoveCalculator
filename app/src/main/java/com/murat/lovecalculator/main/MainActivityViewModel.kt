package com.murat.lovecalculator.main

import androidx.lifecycle.ViewModel
import com.murat.lovecalculator.local.Pref
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(var pref: Pref) : ViewModel(){

    fun isFirstStart() : Boolean{
        return pref.isFirstStart
    }
}