package com.example.quizapplication

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat

class QuestionsActivity : AppCompatActivity(), OnClickListener {

    //all the UI component declarations including TextViews
    private var submitButton: Button? = null

    private var progressBar: ProgressBar? = null
    private var progressNumbersBar: TextView? = null
    private var questionProgress: TextView? = null
    private var questionImage: ImageView? = null

    private var questionOptionOne: TextView? = null
    private var questionOptionTwo: TextView? = null
    private var questionOptionThree: TextView? = null
    private var questionOptionFour: TextView? = null
    private var questionOptionFive: TextView? = null

    //variables to keep track of positioning and selected options, as well as the user's score
    private var myCurrentPosition: Int = 1
    private var myQuestionsList: ArrayList<QuestionData>? = null
    private var mySelectedOptionPos: Int = 0

    private var score: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        //Initialize UI components as well as the TextView options
        progressBar = findViewById(R.id.progressBar)
        progressNumbersBar = findViewById(R.id.access_question_num_progress)
        questionProgress = findViewById(R.id.access_question)
        questionImage = findViewById(R.id.access_image_view)

        submitButton = findViewById(R.id.submit_button)

        //answers option views
        questionOptionOne = findViewById(R.id.access_option_one)
        questionOptionTwo = findViewById(R.id.access_option_two)
        questionOptionThree = findViewById(R.id.access_option_three)
        questionOptionFour = findViewById(R.id.access_option_four)
        questionOptionFive = findViewById(R.id.access_option_five)

        //assigning onclick listeners to our components
        submitButton?.setOnClickListener(this)
        questionOptionOne?.setOnClickListener(this)
        questionOptionTwo?.setOnClickListener(this)
        questionOptionThree?.setOnClickListener(this)
        questionOptionFour?.setOnClickListener(this)
        questionOptionFive?.setOnClickListener(this)

        //fetch question list from QuizConstants and set the first question to the view
        myQuestionsList = QuizConstants.getQuestions()

        setQuestions()
    }

    //new question function
    private fun setQuestions() {
        defaultOptionsView() //set options back to reset colors and defaults

        //fetch current question based on its positioning
        val question: QuestionData = myQuestionsList!![myCurrentPosition - 1]

        //update UI components with question data
        progressBar?.progress = myCurrentPosition
        progressNumbersBar?.text = "$myCurrentPosition/${progressBar?.max}"
        questionImage?.setImageResource(question.image)
        questionProgress?.text = question.question
        questionOptionOne?.text = question.optionOne
        questionOptionTwo?.text = question.optionTwo
        questionOptionThree?.text = question.optionThree
        questionOptionFour?.text = question.optionFour
        questionOptionFive?.text = question.optionFive

        //if statement to set text of submit button based on current positioning
        if (myCurrentPosition == myQuestionsList!!.size) {
            submitButton?.text = "Complete Quiz"
        } else {
            submitButton?.text = "Submit Answer"
        }
    }

    //function to reset options to defaults
    private fun defaultOptionsView() {
        val options = ArrayList<TextView>()

        questionOptionOne?.let {
            options.add(0, it)
        }

        questionOptionTwo?.let {
            options.add(1, it)
        }

        questionOptionThree?.let {
            options.add(2, it)
        }

        questionOptionFour?.let {
            options.add(3, it)
        }

        questionOptionFive?.let {
            options.add(4, it)
        }

        //loop through options and set to default appearance
        for (option in options) {
            option.setTextColor(Color.parseColor("#DCDCDC"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }
    }

    //function to highlight selected option for user readability
    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {
        defaultOptionsView()

        mySelectedOptionPos = selectedOptionNum

        //set provided textview as the selected option and update appearance
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.setTextColor(Color.parseColor("#65a765"))
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.default_option_border_bg
        )
    }

    //handle click events
    override fun onClick(bView: View?) {
        when (bView?.id) {
            R.id.access_option_one -> {
                questionOptionOne?.let {
                    selectedOptionView(it, 1)
                }
            }

            R.id.access_option_two -> {
                questionOptionTwo?.let {
                    selectedOptionView(it, 2)
                }
            }

            R.id.access_option_three -> {
                questionOptionThree?.let {
                    selectedOptionView(it, 3)
                }
            }

            R.id.access_option_four -> {
                questionOptionFour?.let {
                    selectedOptionView(it, 4)
                }
            }

            R.id.access_option_five -> {
                questionOptionFive?.let {
                    selectedOptionView(it, 5)
                }
            }

            R.id.submit_button -> {
                if (mySelectedOptionPos == 0) {
                    myCurrentPosition++

                    when {
                        myCurrentPosition <= myQuestionsList!!.size -> {
                            setQuestions()
                        }

                        else -> {
                            // Calculate the score and display it in activity_results.xml
                            val totalQuestions = myQuestionsList!!.size
                            val percentage = (score * 100) / totalQuestions
                            val resultText = "You scored: $score/$totalQuestions ($percentage%)"

                            // Set the content view to activity_results.xml
                            setContentView(R.layout.activity_results)

                            // Find the TextView in the new layout and set the result text
                            val tvScore = findViewById<TextView>(R.id.tv_score)
                            tvScore.text = resultText
                        }
                    }
                } else {
                    val question = myQuestionsList?.get(myCurrentPosition - 1)
                    if (question!!.correctAnswer != mySelectedOptionPos) {
                        answersView(mySelectedOptionPos, R.drawable.incorrect_option_border_bg)
                    } else {
                        // Increase the score when the answer is correct
                        score++
                    }

                    answersView(question.correctAnswer, R.drawable.correct_option_border_bg)

                    if (myCurrentPosition == myQuestionsList!!.size) {
                        submitButton?.text = "Complete"
                    } else {
                        submitButton?.text = "Next Question"
                    }

                    mySelectedOptionPos = 0 //set selected option back to 0 after each question
                }
            }
        }
    }

    //function to display if the selected answer is correct or not
    private fun answersView(answer: Int, drawableView: Int) {
        when (answer) {
            1 -> {
                questionOptionOne?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }

            2 -> {
                questionOptionTwo?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }

            3 -> {
                questionOptionThree?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }

            4 -> {
                questionOptionFour?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }

            5 -> {
                questionOptionFive?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
        }
    }
}
