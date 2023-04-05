package com.example.iman_tulenaliev_hw_5_2

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.iman_tulenaliev_hw_5_2.remote.LoveApi
import com.example.iman_tulenaliev_hw_5_2.remote.LoveModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(private val api: LoveApi){

    fun getPercentage(firstName: String, secondName: String): MutableLiveData<LoveModel> {
        val mutableLiveData = MutableLiveData<LoveModel>()
        api.getPercentage(firstName, secondName).enqueue(object : Callback<LoveModel>{
            override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                if(response.isSuccessful){
                    mutableLiveData.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                Log.e("123456", "OnFailure ${t.message}")
            }
        })
        return mutableLiveData
    }


}