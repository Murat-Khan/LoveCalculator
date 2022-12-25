package com.murat.lovecalculator

import com.google.gson.annotations.SerializedName

data class LoveModel(
    @SerializedName("fname")
    var fistName : String,
    @SerializedName("sname")
    var secondName : String,
    var percentage : String,
    var result : String,

): java.io.Serializable
