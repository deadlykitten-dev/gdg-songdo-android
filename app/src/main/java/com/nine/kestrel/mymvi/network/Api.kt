package com.nine.kestrel.mymvi.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

/**
 * MyTodo
 * Class: Api
 * Created by sujangmac on 2020-02-01
 *
 * Description:
 */
interface Api {
    @GET(value = "v1/search/movie.json")
    fun getMovieList(
        @Header(value = "X-Naver-Client-Id") clientId: String = "1NUXDsk807uWzySiL1F9",
        @Header(value = "X-Naver-Client-Secret") clientSecret: String = "p7LDHJlZBY",
        @Query(value = "query") query: String
    ): Call<MovieResponse>
}