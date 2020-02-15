package com.nine.kestrel.mymvi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.nine.kestrel.mymvi.adapter.MovieListAdapter
import com.nine.kestrel.mymvi.network.Builder
import com.nine.kestrel.mymvi.network.MovieResponse
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val adapter = MovieListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<RecyclerView>(R.id.rv_movie).adapter = adapter

        button.setOnClickListener { search(et_query.text.toString()) }

        et_query.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(query: Editable?) {
                button.isEnabled = query.toString().isNotEmpty()
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }
        })
        adapter.onClick = {
            val intent = Intent(this, WebViewActivity::class.java).apply {
                putExtra("url", it.link)
            }
            startActivity(intent)
        }

    }

    private fun search(query: String) {
        Builder.api.getMovieList(query = query).enqueue(object : Callback<MovieResponse> {
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Log.d("onFailure", t.toString())
            }

            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                response.body()?.let { adapter.replaceItems(it.movies) }
            }
        })
    }

}
