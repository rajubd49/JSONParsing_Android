package com.rajubd49.jsonparsing.jsonparsingandroid

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.movie_cell.view.*

/**
 * Created by bs195 on 5/29/18.
 */
class MovieAdapter(var movies: Movie): RecyclerView.Adapter<MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MovieViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cell = layoutInflater.inflate(R.layout.movie_cell,parent, false)
        return MovieViewHolder(cell)
    }

    override fun onBindViewHolder(holder: MovieViewHolder?, position: Int) {

        val movie = movies.results[position]
        holder?.itemView?.titleTextView?.text = movie.title
        holder?.itemView?.overviewTextView?.text = movie.overview

        val imageView = holder?.itemView?.posterImageView
        val imageUrl = "https://image.tmdb.org/t/p/w185" + movie.poster_path
        Picasso.get().load(imageUrl).into(imageView)

        holder?.detailsUrl = "https://www.themoviedb.org/movie/" + movie.id
    }

    override fun getItemCount(): Int {
        return movies.results.count()
    }

}


class MovieViewHolder(val view: View, var detailsUrl: String? = null): RecyclerView.ViewHolder(view) {

    companion object {
        val MOVIE_DETAIL_URL_KEY = "MOVIE_DETAIL_URL"
    }
    init {
        view.setOnClickListener {

            val intent = Intent(view.context, WebviewActivity::class.java)
            intent.putExtra(MOVIE_DETAIL_URL_KEY, detailsUrl)
            view.context.startActivity(intent)
        }
    }

}