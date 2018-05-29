package com.rajubd49.jsonparsing.jsonparsingandroid

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_webview.*

class WebviewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview)

        progress_bar.visibility = View.VISIBLE
        val videoUrl = intent.getStringExtra(MovieViewHolder.MOVIE_DETAIL_URL_KEY)

        webView.settings.javaScriptEnabled = true
        webView.settings.loadWithOverviewMode = true
        webView.settings.useWideViewPort = true
        webView.loadUrl(videoUrl)

        webView.webViewClient = object : WebViewClient() {

            override fun onPageFinished(view: WebView, url: String) {
                progress_bar.visibility = View.GONE
            }
        }
    }
}
