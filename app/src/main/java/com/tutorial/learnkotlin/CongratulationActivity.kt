package com.tutorial.learnkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tutorial.learnkotlin.databinding.ActivityCongratulationBinding

class CongratulationActivity : AppCompatActivity() {
    private lateinit var binding : ActivityCongratulationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = ActivityCongratulationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tvUser.text = intent.getStringExtra(Constant.USER_NAME)
        val totalQuestion = intent.getIntExtra(Constant.TotalQuestion,0
        )
        val correctAnswer = intent.getIntExtra(Constant.Correct_Answer,0)
        binding.tvScore.text = "Your score is $correctAnswer out of $totalQuestion"
        binding.btnFinish.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}