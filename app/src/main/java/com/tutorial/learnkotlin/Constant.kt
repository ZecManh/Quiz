package com.tutorial.learnkotlin

import com.tutorial.learnkotlin.model.Question

object Constant {
    fun getQuestion():ArrayList<Question>{
        val questionList = ArrayList<Question>()
        val que1 = Question(1,"1+1 = ?",R.drawable.ic_bg,"2","3","4","5",1)
        val que2 = Question(1,"1+1 = ?",R.drawable.ic_bg,"2","3","4","5",1)
        questionList.add(que1)
        questionList.add(que2)

        return questionList

    }


}