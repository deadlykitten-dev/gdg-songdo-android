package com.nine.kestrel.mymvi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.nine.kestrel.mymvi.adapter.MovieListAdapter
import com.nine.kestrel.mymvi.network.Builder
import com.nine.kestrel.mymvi.network.MovieResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val adapter = MovieListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<RecyclerView>(R.id.rv_movie).adapter = adapter

        Builder.api.getMovieList(query = "스파이더맨").enqueue(object : Callback<MovieResponse> {
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Log.d("onFailure", t.toString())
            }

            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                response.body()?.let { adapter.replaceItems(it.movies) }
            }
        })

    }
}
