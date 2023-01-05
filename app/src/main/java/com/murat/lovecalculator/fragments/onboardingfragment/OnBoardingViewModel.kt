package com.murat.lovecalculator.fragments.onboardingfragment

import androidx.lifecycle.ViewModel
import com.murat.lovecalculator.local.Pref
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(private val pref: Pref):ViewModel(){

    fun setFirstStart(isFirstStart : Boolean) {
        pref.isFirstStart = isFirstStart
    }

}