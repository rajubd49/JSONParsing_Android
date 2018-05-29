package com.rajubd49.jsonparsing.jsonparsingandroid

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_movie.*
import okhttp3.*
import java.io.IOException

class MovieActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)

        progress_bar.visibility = View.VISIBLE
        recycle_view.layoutManager = LinearLayoutManager(this)

        val dividerItemDecoration = DividerItemDecoration(
                recycle_view.context,
                DividerItemDecoration.VERTICAL
        )
        recycle_view.addItemDecoration(dividerItemDecoration)

        //Fetch JSON data from url
        fetchJson()
    }

    private fun fetchJson() {

        val url = "https://api.themoviedb.org/3/search/movie?api_key=1b5adf76a72a13bad99b8fc0c68cb085&query=marvel"
        val request = Request.Builder().url(url).build()

        val client = OkHttpClient()
        client.newCall(request).enqueue(object : Callback {

            override fun onResponse(call: Call?, response: Response?) {
                val responseBody = response?.body()?.string()
                println(responseBody)

                val gson = GsonBuilder().create()
                val movies = gson.fromJson(responseBody, Movie::class.java)

                runOnUiThread {
                    progress_bar.visibility = View.GONE
                    recycle_view.adapter = MovieAdapter(movies)
                }
            }

            override fun onFailure(call: Call?, e: IOException?) {
                println("Failed to fetch JSON from URL")
            }

        })


    }
}
