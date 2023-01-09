package com.murat.lovecalculator.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.murat.lovecalculator.remote.LoveModel
import com.murat.lovecalculator.utils.Constants.LOVE_TABLE

@Dao
interface LoveDao {
    @Insert
    fun insertLove(model: LoveModel)

    @Update
    fun updateLove(model: LoveModel)

    @Query("UPDATE $LOVE_TABLE SET fistName = :fn, secondName = :sn WHERE id = :id ")
    fun update(fn: String?, sn: String?, id :Int? )

    @Delete
    fun deleteLove(model: LoveModel)


    @Query("SELECT * FROM $LOVE_TABLE")
    fun getAll():LiveData<List<LoveModel>>

    @Query("SELECT * FROM $LOVE_TABLE ORDER BY fistName ASC")
        fun getAllSort():LiveData<List<LoveModel>>


}