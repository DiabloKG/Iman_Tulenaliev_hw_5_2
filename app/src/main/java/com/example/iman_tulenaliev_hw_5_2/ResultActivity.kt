package com.example.iman_tulenaliev_hw_5_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.iman_tulenaliev_hw_5_2.databinding.ActivityResultBinding
import com.example.iman_tulenaliev_hw_5_2.remote.LoveModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ResultActivity : AppCompatActivity() {
    lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setData()
    }

    private fun setData() {
        val loveModel = intent.getSerializableExtra("lovemodel") as? LoveModel
        with(binding){
            tvFirstName.text = loveModel?.fname.toString()
            tvSecondName.text = loveModel?.sname.toString()
            tvResult.text = loveModel?.percentage.toString() + "%"
        }
    }
}