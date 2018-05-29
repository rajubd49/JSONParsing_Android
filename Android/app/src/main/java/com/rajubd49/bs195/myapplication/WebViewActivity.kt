package com.rajubd49.bs195.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_feed_detail.*
import kotlinx.android.synthetic.main.activity_web_view.*
import kotlinx.android.synthetic.main.activity_web_view.view.*
import android.widget.ProgressBar
import android.webkit.WebView
import android.webkit.WebViewClient
import com.rajubd49.bs195.myapplication.R.id.webView



class WebViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        webview_progress_bar.visibility = View.VISIBLE
        val videoUrl = intent.getStringExtra(FeedDetailViewHolder.VIDEO_URL_KEY)

        webView.settings.javaScriptEnabled = true
        webView.settings.loadWithOverviewMode = true
        webView.settings.useWideViewPort = true
        webView.loadUrl(videoUrl)

        webView.webViewClient = object : WebViewClient() {

            override fun onPageFinished(view: WebView, url: String) {
                webview_progress_bar.visibility = View.GONE
            }
        }
    }

}
