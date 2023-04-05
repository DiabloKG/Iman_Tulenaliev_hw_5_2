package com.example.iman_tulenaliev_hw_5_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.iman_tulenaliev_hw_5_2.databinding.ActivityLoveBinding
import com.example.iman_tulenaliev_hw_5_2.remote.LoveModel
import com.example.iman_tulenaliev_hw_5_2.remote.LoveService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoveActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoveBinding
    lateinit var loveModel: LoveModel
    val viewModel: LoveViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoveBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClick()
    }

    private fun initClick() {
        with(binding) {
            btnCalculate.setOnClickListener {
                LoveService().api.getPercentage(
                    etFirstName.text.toString(),
                    etSecondName.text.toString(),
                ).enqueue(object : Callback<LoveModel> {
                    override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                        if (response.isSuccessful) {
                            viewModel.getLiveLoveModel(
                                etFirstName.text.toString(),
                                etSecondName.text.toString()
                            ).observe(this@LoveActivity, Observer {
                                Log.e("123456", "onResponse: $it")
                                getData(it)
                            })
                        }
                    }

                    override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                        Log.e("123456", "onResponse:  ${t.message}")
                    }
                })
            }
        }
    }
    fun getData(data: LoveModel){
        loveModel = data
        val intent = Intent(this@LoveActivity, ResultActivity::class.java )
        intent.putExtra("lovemodel", loveModel)
        startActivity(intent)
    }
}