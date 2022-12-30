package com.murat.lovecalculator.repozitory

import android.util.Log
import androidx.lifecycle.MediatorLiveData
import com.murat.lovecalculator.remote.LoveModel
import com.murat.lovecalculator.remote.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository  {

    fun getLiveLove(fistName : String,secondName : String ) : MediatorLiveData<LoveModel>{
        val liveData = MediatorLiveData<LoveModel>()
        RetrofitService().getApi().getResultLove(fistName,secondName)
            .enqueue(object : Callback<LoveModel>{
                override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                    if (response.isSuccessful){
                        liveData.postValue(response.body())
                    }
                }

                override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                    Log.e("raya","${t.message}")
                }
            })
        return liveData
    }
}