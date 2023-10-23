package com.example.quizapplication

//data class to represent question. using it to capture the details for the question such as the text, image, etc.

data class QuestionData(
    val id: Int,
    val question: String,
    val image: Int,
    val optionOne: String,
    val optionTwo: String,
    val optionThree: String,
    val optionFour: String,
    val optionFive: String,
    val correctAnswer: Int
)
