package com.nine.kestrel.mymvi.network

import com.google.gson.annotations.SerializedName

/**
 * MyTodo
 * Class: Movie
 * Created by sujangmac on 2020-02-01
 *
 * Description:
 */
data class Movie(
    @SerializedName("actor")
    val actor: String,
    @SerializedName("director")
    val director: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("link")
    val link: String,
    @SerializedName("pubDate")
    val pubDate: String,
    @SerializedName("subtitle")
    val subtitle: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("userRating")
    val userRating: Float
)