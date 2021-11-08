package com.dsc.movie.Fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dsc.movie.Adapter.RecyclerViewAdapter
import com.dsc.movie.DetailMovie
import com.dsc.movie.Model.Movie
import com.dsc.movie.R

class PopularMovie : Fragment(){

    private val Movie = mutableListOf<Movie>()
    private lateinit var adapter: RecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_popular_movie, container, false)

        Movie.add(
            Movie(
                "popmov",
                "https://asianwiki.com/images/1/1c/Kingdom-_Ashin_of_the_North-P2.jpg",
                1
            )
        )
        Movie.add(
            Movie(
                "popmov",
                "https://asianwiki.com/images/1/1c/Kingdom-_Ashin_of_the_North-P2.jpg",
                2
            )
        )
        Movie.add(
            Movie(
                "popmov",
                "https://asianwiki.com/images/1/1c/Kingdom-_Ashin_of_the_North-P2.jpg",
                3
            )
        )

        val rv = view.findViewById<RecyclerView>(R.id.rcvPopular)
        adapter = RecyclerViewAdapter()
        rv.apply {
            layoutManager = GridLayoutManager(context, 2)
        }
        rv.adapter = adapter
        adapter.updateData(Movie)

        return view
    }


}