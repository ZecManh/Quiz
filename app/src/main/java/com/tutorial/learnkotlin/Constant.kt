package com.tutorial.learnkotlin

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.tutorial.learnkotlin.model.Question
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader


object Constant {
    const val  USER_NAME : String = "user_name"
    const val TotalQuestion : String = "total_question"
    const val  Correct_Answer:String = "correct_answer"
    fun getQuestion(context: Context):ArrayList<Question>{
        val inputStream: InputStream = context.resources.openRawResource(R.raw.quiz)
        val bufferedReader = BufferedReader(InputStreamReader(inputStream))
        val jsonStringBuilder = StringBuilder()
        var line: String? = null
        while ({ line = bufferedReader.readLine(); line }() != null) {
            jsonStringBuilder.append(line)
        }
        val jsonString = jsonStringBuilder.toString()
        val gson = Gson()
        val questionListType = object : TypeToken<ArrayList<Question>>() {}.type
        val questionList = gson.fromJson<ArrayList<Question>>(jsonString, questionListType)

        return questionList

    }


}