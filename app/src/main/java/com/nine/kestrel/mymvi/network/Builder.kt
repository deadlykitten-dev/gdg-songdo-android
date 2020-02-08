package com.nine.kestrel.mymvi.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * MyTodo
 * Class: Builder
 * Created by sujangmac on 2020-02-01
 *
 * Description:
 */
object Builder {
    val api: Api = Retrofit.Builder()
        .baseUrl("https://openapi.naver.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(Api::class.java)

}