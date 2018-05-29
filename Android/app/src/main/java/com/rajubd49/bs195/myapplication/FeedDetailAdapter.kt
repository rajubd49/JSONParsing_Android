package com.rajubd49.bs195.myapplication

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.rajubd49.bs195.myapplication.FeedViewHolder.Companion.FEED_DETAIL_ID_KEY
import com.rajubd49.bs195.myapplication.FeedViewHolder.Companion.FEED_DETAIL_TITLE_KEY
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.feeddetail_cell.view.*

/**
 * Created by bs195 on 4/5/18.
 */

class FeedDetailAdapter(var feedDetail: Array<FeedDetail>): RecyclerView.Adapter<FeedDetailViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): FeedDetailViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cell = layoutInflater.inflate(R.layout.feeddetail_cell,parent, false)
        return FeedDetailViewHolder(cell)
    }

    override fun onBindViewHolder(holder: FeedDetailViewHolder?, position: Int) {

        val feedDetail = feedDetail[position]
        holder?.itemView?.title_text_view?.text = feedDetail.name
        holder?.itemView?.subtitle_text_view?.text = "Episode #" + feedDetail.number.toString()
        holder?.itemView?.duration_text_view?.text = feedDetail.duration

        val imageView = holder?.itemView?.image_view
        Picasso.get().load(feedDetail.imageUrl).into(imageView)

        holder?.feedDetail = feedDetail
    }

    override fun getItemCount(): Int {
        return feedDetail.count()
    }

}


class FeedDetailViewHolder(val view:View, var feedDetail: FeedDetail? = null): RecyclerView.ViewHolder(view) {

    companion object {
        val VIDEO_URL_KEY = "VIDEO_URL"
    }
    init {
        view.setOnClickListener {

            val videoUrl = feedDetail?.link
            if (videoUrl?.count() != 0) {
                val intent = Intent(view.context, WebViewActivity::class.java)
                intent.putExtra(VIDEO_URL_KEY, feedDetail?.link)
                view.context.startActivity(intent)
            } else {
                Toast.makeText(view.context,"Details unavailable", Toast.LENGTH_SHORT).show()
            }

        }
    }

}