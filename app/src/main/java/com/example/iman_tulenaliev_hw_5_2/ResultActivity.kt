package com.example.iman_tulenaliev_hw_5_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.iman_tulenaliev_hw_5_2.databinding.ActivityResultBinding
import com.example.iman_tulenaliev_hw_5_2.remote.LoveModel

lateinit var binding2: ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding2 = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding2.root)
        setData()
    }

    private fun setData() {
        val loveModel = intent.getSerializableExtra("lovemodel") as? LoveModel
        with(binding2){
            tvFirstName.text = loveModel?.fname.toString()
            tvSecondName.text = loveModel?.sname.toString()
            tvResult.text = "Результат: " + loveModel?.percentage.toString()
        }
    }
}