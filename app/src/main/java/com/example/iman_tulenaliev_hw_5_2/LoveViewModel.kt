package com.example.iman_tulenaliev_hw_5_2

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.iman_tulenaliev_hw_5_2.remote.LoveModel

class LoveViewModel : ViewModel() {

    private val repository = Repository()

    fun getLiveLoveModel(firstName: String, secondName: String) : LiveData<LoveModel>{
        return repository.getPercentage(firstName, secondName)
    }
}