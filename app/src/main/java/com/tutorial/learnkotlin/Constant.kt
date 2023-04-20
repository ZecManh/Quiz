package com.tutorial.learnkotlin

import com.tutorial.learnkotlin.model.Question

object Constant {
    const val  USER_NAME : String = "user_name"
    const val TotalQuestion : String = "total_question"
    const val  Correct_Answer:String = "correct_answer"
    fun getQuestion():ArrayList<Question>{
        val questionList = ArrayList<Question>()
        val que1 = Question(1,"what country does this flag belong to",R.drawable.ic_flag_of_argentina,"Argentina","France","Belgium","Australia",1)
        val que2 = Question(2,"what country does this flag belong to",R.drawable.ic_flag_of_argentina,"Argentina","France","Belgium","Australia",1)
        val que3 = Question(3,"what country does this flag belong to",R.drawable.ic_flag_of_argentina,"Argentina","France","Belgium","Australia",1)
        val que4 = Question(4,"what country does this flag belong to",R.drawable.ic_flag_of_argentina,"Argentina","France","Belgium","Australia",1)
        val que5 = Question(5,"what country does this flag belong to",R.drawable.ic_flag_of_argentina,"Argentina","France","Belgium","Australia",1)
        val que6 = Question(6,"what country does this flag belong to",R.drawable.ic_flag_of_argentina,"Argentina","France","Belgium","Australia",1)
        val que7 = Question(7,"what country does this flag belong to",R.drawable.ic_flag_of_argentina,"Argentina","France","Belgium","Australia",1)
        questionList.add(que1)
        questionList.add(que2)
        questionList.add(que3)
        questionList.add(que4)
        questionList.add(que5)
        questionList.add(que6)
        questionList.add(que7)

        return questionList

    }


}