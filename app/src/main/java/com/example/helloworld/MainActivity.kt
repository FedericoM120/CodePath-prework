package com.example.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast


//this file is for user interaction

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // show the layout file: activity_main
        setContentView(R.layout.activity_main)

        //display customized text to show 'hello from {name}'

        //user taps button to change text color of label
        // 1. add button to layout
        // get reference to button
        // 2. set up logic to know when user taps on button
        findViewById<Button>(R.id.button).setOnClickListener {
            //handles button tap
            //2. change the color of the text
            Log.i("Federico", "Tapped on button")
            //1.get a reference to the text view
            //2.set the color of the textview
            findViewById<TextView>(R.id.textView).setTextColor(getResources().getColor(R.color.purple_700))
        }
        //user taps background to reset all views to default settings
        findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.backgroundView).setOnClickListener {
            Log.i("backgroundClicked", "background Clicked")
            findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.backgroundView).setBackgroundColor(getResources().getColor(R.color.teal_200))
            findViewById<TextView>(R.id.textView).setTextColor(getResources().getColor(R.color.black))
            val message = findViewById<EditText>(R.id.inputText).text.toString()
            val nicknameTextView = findViewById<TextView>(R.id.textView)
            nicknameTextView.text = "Hello from Federico!"

        }
        //user taps on button to change background colo
        findViewById<Button>(R.id.button2).setOnClickListener {
            //handles backgroundColor button tap
            Log.i("button2Caller", "Tapped on button2")
            //1. get a reference to the backgroundView
            //2. set the color of the backgroundView
            findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.backgroundView).setBackgroundColor(getResources().getColor(R.color.yellow))
        }
        //this function assigns the text entered in editText to the textView text
        fun addNickname(view: View) {
            val editText = findViewById<EditText>(R.id.inputText)
            val nicknameTextView = findViewById<TextView>(R.id.textView)
            nicknameTextView.text = editText.text
        }

        //user taps on button to change textView text to the text he entered in the editText box
        findViewById<Button>(R.id.button3).setOnClickListener {
            //created to convert editText to a string
            val message = findViewById<EditText>(R.id.inputText).text.toString()
            //created value to assign default text to it in the if else statement below 
            val nicknameTextView = findViewById<TextView>(R.id.textView)
            //if editText is entered empty return the default string in the textView else call function addNickname
            if (message == "") {
                nicknameTextView.text = "Hello from Federico!"
            } else {
                addNickname(it)
            }
        }

    }

}