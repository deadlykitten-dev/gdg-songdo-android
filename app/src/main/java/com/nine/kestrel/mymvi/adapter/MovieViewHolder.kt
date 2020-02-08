package com.nine.kestrel.mymvi.adapter

import android.view.View
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nine.kestrel.mymvi.R
import com.nine.kestrel.mymvi.network.Movie

/**
 * My Mvi
 * Class: MovieViewHolder
 * Created by sujangmac on 2020-02-03
 *
 * Description:
 */
class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val image = itemView.findViewById<ImageView>(R.id.iv_image)
    private val title = itemView.findViewById<TextView>(R.id.tv_title)
    private val userRating = itemView.findViewById<RatingBar>(R.id.rb_userRating)
    private val director = itemView.findViewById<TextView>(R.id.tv_director)
    private val actor = itemView.findViewById<TextView>(R.id.tv_actor)

    fun bind(item: Movie) {
        Glide.with(itemView)
            .load(item.image)
            .into(image)
        title.text = item.title
        userRating.rating = item.userRating.div(2)
        director.text = item.director
        actor.text = item.actor
    }
}

//if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//    this.text = Html.fromHtml(str, Html.FROM_HTML_MODE_LEGACY)
//} else {
//    @Suppress("DEPRECATION")
//    this.text = Html.fromHtml(str)
//}