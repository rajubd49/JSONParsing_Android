package com.rajubd49.bs195.myapplication

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_number.*
import okhttp3.*
import java.io.IOException

class NumberActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_number)

        val numbers = listOf("One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten")
        recycle_view.layoutManager = LinearLayoutManager(this)
        recycle_view.adapter = NumberAdapter(numbers)

    }
}

