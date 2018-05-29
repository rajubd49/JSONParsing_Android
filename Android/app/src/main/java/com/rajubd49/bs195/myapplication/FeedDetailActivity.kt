package com.rajubd49.bs195.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_feed_detail.*
import kotlinx.android.synthetic.main.activity_home_feed.*
import okhttp3.*
import java.io.IOException
import android.support.v7.widget.DividerItemDecoration
import android.view.View


class FeedDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed_detail)

        homedetail_progress_bar.visibility = View.VISIBLE

        feeddetail_recycle_view.layoutManager = LinearLayoutManager(this)
        val dividerItemDecoration = DividerItemDecoration(
                feeddetail_recycle_view.context,
                DividerItemDecoration.VERTICAL
        )
        feeddetail_recycle_view.addItemDecoration(dividerItemDecoration)

        val navBarTitle = intent.getStringExtra(FeedViewHolder.FEED_DETAIL_TITLE_KEY)
        supportActionBar?.title = navBarTitle

        //Fetch JSON data from url
        fetchJson()

    }

    private fun fetchJson() {

        val videoId = intent.getIntExtra(FeedViewHolder.FEED_DETAIL_ID_KEY, -1)
        val url = "https://api.letsbuildthatapp.com/youtube/course_detail?id=$videoId"
        val request = Request.Builder().url(url).build()

        val client = OkHttpClient()
        client.newCall(request).enqueue(object : Callback {

            override fun onResponse(call: Call?, response: Response?) {
                val responseBody = response?.body()?.string()
//                println(responseBody)

                val gson = GsonBuilder().create()
                val feedDetail = gson.fromJson(responseBody, Array<FeedDetail>::class.java)

                runOnUiThread {
                    homedetail_progress_bar.visibility = View.GONE
                    feeddetail_recycle_view.adapter = FeedDetailAdapter(feedDetail)
                }
            }

            override fun onFailure(call: Call?, e: IOException?) {
                println("Failed to fetch JSOn from URL")
            }

        })


    }
}
