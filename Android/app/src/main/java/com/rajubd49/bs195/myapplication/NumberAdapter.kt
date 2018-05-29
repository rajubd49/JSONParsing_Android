package com.rajubd49.bs195.myapplication

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.number_cell.view.*

/**
 * Created by bs195 on 4/4/18.
 */

class NumberAdapter(var numbers: List<String>): RecyclerView.Adapter<CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cell = layoutInflater.inflate(R.layout.number_cell,parent, false)
        return CustomViewHolder(cell)
    }

    override fun onBindViewHolder(holder: CustomViewHolder?, position: Int) {
        holder?.itemView?.title_text_view?.text = numbers.get(position)
        holder?.itemView?.subtitle_text_view?.text = "Subtitle " + numbers.get(position)
        holder?.itemView?.image_view?.setImageResource(R.drawable.cake)
    }

    override fun getItemCount(): Int {
        return numbers.count()
    }

}


class CustomViewHolder(view:View): RecyclerView.ViewHolder(view) {

}