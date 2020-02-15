package com.nine.kestrel.mymvi.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nine.kestrel.mymvi.R
import com.nine.kestrel.mymvi.network.Movie

/**
 * My Mvi
 * Class: MovieListAdapter
 * Created by sujangmac on 2020-02-03
 *
 * Description:
 */

class MovieListAdapter : RecyclerView.Adapter<MovieViewHolder>() {

    private val items = mutableListOf<Movie>()

    var onClick: (item: Movie) -> Unit = {}

    fun replaceItems(items: List<Movie>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(view)
    }

    //    override fun getItemCount(): Int = items.size
    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val item = items[position]
        holder.itemView.setOnClickListener { onClick(item) }
        holder.bind(item)
    }
}