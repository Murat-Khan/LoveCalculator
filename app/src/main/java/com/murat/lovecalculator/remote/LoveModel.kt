package com.murat.lovecalculator.remote

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.murat.lovecalculator.utils.Constants.LOVE_TABLE

    @Entity(tableName = LOVE_TABLE)
data class LoveModel(
    @SerializedName("fname")
    var fistName : String,
    @SerializedName("sname")
    var secondName : String,
    var percentage : String? = null,
    var result : String? = null,
    @PrimaryKey(autoGenerate = true)
    var id : Int? = null

): java.io.Serializable
