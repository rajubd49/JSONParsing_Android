package com.rajubd49.bs195.myapplication

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.homefeed_cell.view.*

/**
 * Created by bs195 on 4/4/18.
 */

class HomeFeedAdapter(var homeFeed: HomeFeed): RecyclerView.Adapter<FeedViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): FeedViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cell = layoutInflater.inflate(R.layout.homefeed_cell,parent, false)
        return FeedViewHolder(cell)
    }

    override fun onBindViewHolder(holder: FeedViewHolder?, position: Int) {

        val video = homeFeed.videos[position]
        holder?.itemView?.nameTextView?.text = video.name
        holder?.itemView?.channelNameTextView?.text = video.channel.name

        val imageView = holder?.itemView?.imageView
        Picasso.get().load(video.imageUrl).into(imageView)

        val channelImageView = holder?.itemView?.profileImageView
        Picasso.get().load(video.channel.profileImageUrl).into(channelImageView)

        holder?.video = video
    }

    override fun getItemCount(): Int {
        return homeFeed.videos.count()
    }

}


class FeedViewHolder(val view:View, var video: Video? = null): RecyclerView.ViewHolder(view) {

    companion object {
        val FEED_DETAIL_TITLE_KEY = "FEED_DETAIL_TITLE"
        val FEED_DETAIL_ID_KEY = "FEED_DETAIL_ID"
    }
    init {
        view.setOnClickListener {

            val intent = Intent(view.context, FeedDetailActivity::class.java)
            intent.putExtra(FEED_DETAIL_TITLE_KEY, video?.name)
            intent.putExtra(FEED_DETAIL_ID_KEY, video?.id)

            view.context.startActivity(intent)
        }
    }

}