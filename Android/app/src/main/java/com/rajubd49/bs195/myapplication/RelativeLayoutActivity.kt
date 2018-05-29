package com.rajubd49.bs195.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_relative_layout.*

class RelativeLayoutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_relative_layout)
    }

    fun loginButtonClicked (view: View) {
        Toast.makeText(this,"Login successful",Toast.LENGTH_SHORT).show()

//        val progressBar = this.progress_bar
//        val signUp = this.signup_button
//        progressBar.visibility = View.VISIBLE
//        signUp.visibility = View.INVISIBLE
    }

}
