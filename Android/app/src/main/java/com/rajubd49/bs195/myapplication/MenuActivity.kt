package com.rajubd49.bs195.myapplication

import android.content.Intent
import android.icu.text.SelectFormat
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val numberTextView = this.number_text_view
        numberTextView.setOnClickListener() {
            val numberActivity = Intent(this, NumberActivity::class.java)
            startActivity(numberActivity)
        }
    }

}
