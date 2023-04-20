package com.tutorial.learnkotlin

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.content.IntentCompat
import com.tutorial.learnkotlin.databinding.ActivityQuizBinding
import com.tutorial.learnkotlin.model.Question

class QuizActivity : AppCompatActivity(),View.OnClickListener {
    private lateinit var binding:ActivityQuizBinding
    private var mCurrentPosition :Int = 1
    private var listQuestion : ArrayList<Question>? = null
    private var mselectOption: Int = 0
    private  var mUsername : String? = null
    private var mCorrect : Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mUsername = intent.getStringExtra(Constant.USER_NAME)

        binding.answer1.setOnClickListener(this)
        binding.answer2.setOnClickListener(this)
        binding.answer3.setOnClickListener(this)
        binding.answer4.setOnClickListener(this)
        binding.submit.setOnClickListener(this)
        listQuestion = Constant.getQuestion()
        setQuestion()
        optionView()
    }

    private fun setQuestion() {
        optionView()
       mCurrentPosition = 1
        val question: Question = listQuestion!![mCurrentPosition - 1]
        binding.pbQuiz.progress = mCurrentPosition
        binding.tvPb.text = "$mCurrentPosition / ${binding.pbQuiz.max}"
        binding.tvQuestion.text = question.question
        binding.answer1.text = question.option1
        binding.answer2.text = question.option2
        binding.answer3.text = question.option3
        binding.answer4.text = question.option4
        binding.imgQuiz.setImageResource(question.image)
        if (mCurrentPosition == listQuestion!!.size){
            binding.submit.text = "Finish"
        }else{
            binding.submit.text = "Submit"
        }
    }
    private fun optionView(){
        val options = ArrayList<Button>()
        binding.answer1.let {
              options.add(0,it)
        }

        binding.answer2.let {
            options.add(1,it)
        }

        binding.answer3.let {
            options.add(2,it)
        }

        binding.answer4.let {
            options.add(3,it)
        }
        for (option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,R.drawable.select_option_default
            )
        }

    }
    private fun selectOptionView(bt:Button,selectOption:Int){
        optionView()
        mselectOption = selectOption
        bt.setTextColor(Color.parseColor("#363A43"))
       bt.setTypeface(bt.typeface,Typeface.BOLD)
        bt.background = ContextCompat.getDrawable(
            this,R.drawable.select_option_button
        )
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.answer1 ->{
                binding.answer1.let {
                    selectOptionView(it,1)
                }
            }
            R.id.answer2 ->{
                binding.answer2.let {
                    selectOptionView(it,2)
                }
            }
            R.id.answer3 ->{
                binding.answer3.let {
                    selectOptionView(it,3)
                }
            }
            R.id.answer4 ->{
                binding.answer4.let {
                    selectOptionView(it,4)
                }
            }
            R.id.submit ->{
             if (mselectOption ==0){
                 mCurrentPosition++
                 when{
                     mCurrentPosition <= listQuestion!!.size ->{
                         setQuestion()
                     }
                     else ->{
                        val intent = Intent(this,CongratulationActivity::class.java)
                         intent.putExtra(Constant.USER_NAME,mUsername)
                         intent.putExtra(Constant.Correct_Answer,mCorrect)
                         intent.putExtra(Constant.TotalQuestion,listQuestion?.size)
                         startActivity(intent)
                         finish()
                     }
                 }
             }else{
                 val question = listQuestion?.get(mCurrentPosition - 1)
                 if (question!!.correctAnswer != mselectOption){
                     answerView(mselectOption,R.drawable.wrong_option_button)
                 }else{
                     mCorrect++
                 }
                 answerView(question.correctAnswer,R.drawable.correct_option_button)
                 if(mCurrentPosition == listQuestion!!.size){
                     binding.submit.text = "Finish"
                 }else{
                     binding.submit.text = "Go to next Question"
                 }
                 mselectOption = 0
             }
            }
        }
    }
    private fun answerView(answer:Int,drawableView: Int){
        when(answer){
            1 -> {
                binding.answer1.background = ContextCompat.getDrawable(
                    this,drawableView
                )
            }
            2-> {
                binding.answer2.background = ContextCompat.getDrawable(
                    this,drawableView
                )
            }
            3 -> {
                binding.answer3.background = ContextCompat.getDrawable(
                    this,drawableView
                )
            }
            4 -> {
                binding.answer4.background = ContextCompat.getDrawable(
                    this,drawableView
                )
            }

        }
    }
}