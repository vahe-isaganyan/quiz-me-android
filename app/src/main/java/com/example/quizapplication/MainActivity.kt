package com.example.quizapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.content.Intent
import android.content.Context
import android.content.SharedPreferences

class MainActivity : AppCompatActivity() {

    // define constant key for the user name in SharedPreferences
    private val USER_NAME_KEY = "user_name_key"

    // declare SharedPreferences variable to store users details
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        // initialize the SharedPreferences with the name UserName
        sharedPreferences = getSharedPreferences("UserName", Context.MODE_PRIVATE)

        // bind start button and name input from layout
        val buttonStart: Button = findViewById(R.id.buttonStart)
        val editName: EditText = findViewById(R.id.editName)

        // click listener for the start button
        buttonStart.setOnClickListener {
            // Check if user has entered their name. Show toast message if not.
            if (editName.text.isEmpty()) {
                Toast.makeText(this, "Enter your name", Toast.LENGTH_LONG).show()
            } else {
                // save name in SharedPreferences
                val editor = sharedPreferences.edit()
                editor.putString(USER_NAME_KEY, editName.text.toString())
                editor.apply()

                // intent to move to the QuestionsActivity.
                val intent = Intent(this, QuestionsActivity::class.java)

                // Start the QuestionsActivity and close the current activity so users can't accidentally go back and restart quiz.
                startActivity(intent)
                finish()
            }
        }
    }
}
