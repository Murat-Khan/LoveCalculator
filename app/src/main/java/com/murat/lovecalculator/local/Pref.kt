package com.murat.lovecalculator.local

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import com.murat.lovecalculator.utils.Constants.KEY_PREFERENCE_NAME
import com.murat.lovecalculator.utils.Constants.SHOW_BOARDING

class Pref (private val context: Context){

    private var pref : SharedPreferences = context.getSharedPreferences(
        KEY_PREFERENCE_NAME,
        Context.MODE_PRIVATE)

    var isFirstStart: Boolean
        get() {
            return pref.getBoolean(SHOW_BOARDING, true)
        }
        set(value) {
            pref.edit {
                putBoolean(SHOW_BOARDING, value)
            }

}
    }