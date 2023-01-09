package com.murat.lovecalculator.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.murat.lovecalculator.remote.LoveModel


@Database(entities = [LoveModel::class], version = 1)
abstract class LoveDataBase : RoomDatabase() {
    abstract fun getDao():LoveDao



}