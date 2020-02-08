package com.nine.kestrel.mymvi.network

import com.google.gson.annotations.SerializedName

/**
 * MyTodo
 * Class: Movie
 * Created by sujangmac on 2020-02-01
 *
 * Description:
 */


data class MovieResponse(
    @SerializedName("display")
    val display: Int,
    @SerializedName("items")
    val movies: List<Movie>,
    @SerializedName("lastBuildDate")
    val lastBuildDate: String,
    @SerializedName("start")
    val start: Int,
    @SerializedName("total")
    val total: Int
)