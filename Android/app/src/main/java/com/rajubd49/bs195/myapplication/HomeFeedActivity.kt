package com.rajubd49.bs195.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.google.gson.GsonBuilder
import android.view.View
import kotlinx.android.synthetic.main.activity_feed_detail.*
import kotlinx.android.synthetic.main.activity_home_feed.*
import kotlinx.android.synthetic.main.activity_number.*
import kotlinx.android.synthetic.main.activity_relative_layout.*
import okhttp3.*
import java.io.IOException

class HomeFeedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_feed)


        home_progress_bar.visibility = View.VISIBLE
        homefeed_recycle_view.layoutManager = LinearLayoutManager(this)

        val dividerItemDecoration = DividerItemDecoration(
                homefeed_recycle_view.context,
                DividerItemDecoration.VERTICAL
        )
        homefeed_recycle_view.addItemDecoration(dividerItemDecoration)

        //Fetch JSON data from url
        fetchJson()
    }

    private fun fetchJson() {
//        println("Fetch JSON from URL")

        val url = "https://api.letsbuildthatapp.com/youtube/home_feed"
        val request = Request.Builder().url(url).build()

        val client = OkHttpClient()
        client.newCall(request).enqueue(object : Callback {

            override fun onResponse(call: Call?, response: Response?) {
                val responseBody = response?.body()?.string()
//                println(responseBody)

                val gson = GsonBuilder().create()
                val homeFeed = gson.fromJson(responseBody, HomeFeed::class.java)

                runOnUiThread {
                    home_progress_bar.visibility = View.GONE
                    homefeed_recycle_view.adapter = HomeFeedAdapter(homeFeed)
                }
            }

            override fun onFailure(call: Call?, e: IOException?) {
                println("Failed to fetch JSOn from URL")
            }

        })


    }
}
