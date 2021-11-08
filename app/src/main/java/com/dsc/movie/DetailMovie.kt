package com.dsc.movie

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.dsc.movie.Adapter.RecyclerViewAdapter
import com.dsc.movie.Model.Movie

class DetailMovie : AppCompatActivity() {

    private val Movie = mutableListOf<Movie>()
    private lateinit var adapter: RecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie)

        val mToolbar = findViewById<Toolbar>(R.id.Toolbar)
        val mTitle = findViewById<TextView>(R.id.title)
        val mPoster = findViewById<ImageView>(R.id.Poster)
        val mSmallPoster = findViewById<ImageView>(R.id.smallPoster)
        val mDate = findViewById<TextView>(R.id.date)
        val mDuration = findViewById<TextView>(R.id.duration)
        val mRate = findViewById<TextView>(R.id.rate)
        val mDesc = findViewById<TextView>(R.id.desc)


        val title = intent.getStringExtra("title")
        val img = intent.getStringExtra("img")
        val Id = intent.getStringExtra("Id")

        //ActionBar title dan tombol back
        setSupportActionBar(mToolbar)
        supportActionBar?.apply {
            setTitle(title)
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

        mTitle.setText(title)


    }
    override fun onSupportNavigateUp(): Boolean {
        //menutup activity
         finish()
        return true
    }

}