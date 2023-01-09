package com.murat.lovecalculator

import android.app.Application
import androidx.room.Room
import com.murat.lovecalculator.room.LoveDataBase
import com.murat.lovecalculator.utils.Constants
import com.murat.lovecalculator.utils.Constants.LOVE_DATABASE
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {

  /*  companion object{
        lateinit var db : LoveDataBase
    }*/

    override fun onCreate() {
        super.onCreate()

      /*  db = Room.databaseBuilder(applicationContext, LoveDataBase::class.java,
           LOVE_DATABASE).allowMainThreadQueries().build()*/

    }
}