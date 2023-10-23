package com.example.quizapplication

//object class for quiz constants and helper methods
object QuizConstants {

    //function to generate a list of questions for the quiz. Questions are hardcoded.
    //start with an empty list to store questions
    fun getQuestions(): ArrayList<QuestionData> {

        val questionList = ArrayList<QuestionData>()

        /**
         * Code to create list of questions. Each question is defined using the QuestionData class.
         * after each question is created it is added to the questionList
         * each question requires an id to be associated and there's a drawable image added from free use sources
         * to add appeal.
         */
        val question1 = QuestionData(
            1,
            "Select the keyword used to declare a function in Kotlin.",
            R.drawable.ic_kotlin,
            "declare",
            "fun",
            "def",
            "define",
            "function",
            2
        )
        questionList.add(question1)

        val question2 = QuestionData(
            2,
            "By default, a ____ represents the items in a row or column when using GridLayout in Android Studio.",
            R.drawable.ic_android,
            "span",
            "layout",
            "grid",
            "container",
            "cell",
            1,
        )
        questionList.add(question2)

        val question3 = QuestionData(
            3,
            "Which of the following choices is NOT a valid lifecycle method of 'Activity'? in Android Studio",
            R.drawable.ic_android,
            "onResume",
            "onCreate",
            "onActivate",
            "onStart",
            "onEnd",
            3,
        )
        questionList.add(question3)

        val question4 = QuestionData(
            4,
            "Which permission is required to access a user's fine-grained location in Android Studio?",
            R.drawable.ic_android,
            "android.permission.ACCESS_LOCATION_BACKGROUND",
            "android.permission.ACCESS_COARSE_LOCATION",
            "android.permission.READ_PRECISE_LOCATION",
            "android.permission.ACCESS_ACCURATE_LOCATION",
            "android.permission.ACCESS_FINE_LOCATION",
            5,
        )
        questionList.add(question4)

        val question5 = QuestionData(
            5,
            "Select the keyword used to declare a constant value in Kotlin.",
            R.drawable.ic_kotlin,
            "static",
            "var",
            "val",
            "cons",
            "const",
            5,
        )
        questionList.add(question5)

        val question6 = QuestionData(
            6,
            "Which operator in Kotlin is used to compare two values?",
            R.drawable.ic_kotlin,
            "=",
            "==",
            "<>",
            "/",
            "===",
            2,
        )
        questionList.add(question6)

        val question7 = QuestionData(
            7,
            "In Android Studio, which layout is recommended for a vertically stacked view? in Android Studio?",
            R.drawable.ic_android_cool,
            "LinearLayout",
            "FrameLayout",
            "ConstraintLayout",
            "FrameLayout",
            "VerticalLayout",
            1,
        )
        questionList.add(question7)

        val question8 = QuestionData(
            8,
            "In Kotlin, how do you create a variable with the floating number 3.5?",
            R.drawable.ic_kotlin_2,
            "num = 3.5fl",
            "float num = 3.5",
            "float num = 3.5f",
            "num = 3.5 float",
            "val num = 3.5",
            5,
        )
        questionList.add(question8)

        val question9 = QuestionData(
            9,
            "What is the default file name for the main activity layout in Android Studio?",
            R.drawable.ic_android_cool,
            "main_activity.xml",
            "activity_layout.xml",
            "default_activity.xml",
            "activity_main.xml",
            "primary_activity.xml",
            4,
        )
        questionList.add(question9)

        val question10 = QuestionData(
            10,
            "In Android Studio, which folder is the primary folder for app icons and images?",
            R.drawable.ic_android,
            "res/drawable",
            "res/assets",
            "res/images",
            "res/draw",
            "src/assets",
            1,
        )
        questionList.add(question10)


        return questionList
    }
}