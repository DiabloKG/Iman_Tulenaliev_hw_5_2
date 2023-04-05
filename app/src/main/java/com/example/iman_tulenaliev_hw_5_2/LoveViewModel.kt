package com.example.iman_tulenaliev_hw_5_2

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.iman_tulenaliev_hw_5_2.remote.LoveModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoveViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    fun getLiveLoveModel(firstName: String, secondName: String) : LiveData<LoveModel>{
        return repository.getPercentage(firstName, secondName)
    }
}