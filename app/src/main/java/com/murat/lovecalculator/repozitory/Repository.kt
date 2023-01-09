package com.murat.lovecalculator.repozitory

import android.util.Log
import androidx.lifecycle.MediatorLiveData
import com.murat.lovecalculator.remote.LoveApi
import com.murat.lovecalculator.remote.LoveModel
import com.murat.lovecalculator.room.LoveDao

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(private val api : LoveApi,private val dao : LoveDao)
{

    fun getLiveLove(fistName : String,secondName : String ) : MediatorLiveData<LoveModel>{
        val liveData = MediatorLiveData<LoveModel>()
        api.getResultLove(fistName,secondName)
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


    fun saveLove(loveModel: LoveModel) = dao.insertLove(loveModel)
    fun getAllSort() = dao.getAllSort()
    fun getLove() = dao.getAll()
    fun updateNote(loveModel: LoveModel) = dao.updateLove(loveModel)
    fun update(secondName: String,fistName: String,id : Int) = dao.update(secondName,fistName, id)





}