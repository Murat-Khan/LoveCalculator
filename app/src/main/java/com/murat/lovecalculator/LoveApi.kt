package com.murat.lovecalculator

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface LoveApi {
    @GET("getPercentage")
    fun getResultLove(
        @Query("fname") fistName :String,
        @Query("sname") secondName : String,
    @Header("X-RapidAPI-Key") key: String =  "f9ab0e0accmsh3e1b478d57ba19dp16a133jsndc9822479db0",
    @Header("X-RapidAPI-Host") host :String = "love-calculator.p.rapidapi.com"):Call<LoveModel>
}