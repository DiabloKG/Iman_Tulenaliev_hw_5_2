package com.example.iman_tulenaliev_hw_5_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.os.bundleOf
import com.example.iman_tulenaliev_hw_5_2.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

lateinit var binding: ActivityMainBinding
lateinit var loveModel: LoveModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClick()
    }

    private fun initClick() {
        with(binding){
            btnCalculate.setOnClickListener{
                LoveService().api.getPercentage(etFirstName.text.toString(),
                etSecondName.text.toString(),
                ).enqueue(object :Callback<LoveModel>{
                    override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                        if (response.isSuccessful){
                            Log.e("123456" , "onResponse:  ${response.body()}" )
                            loveModel = response.body()!!
                            val intent = Intent(this@MainActivity, ResultActivity::class.java )
                            intent.putExtra("lovemodel", loveModel)
                            startActivity(intent)
                        }
                    }

                    override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                        Log.e("123456" , "onResponse:  ${t.message}" )
                    }

                })
            }
        }
    }
}