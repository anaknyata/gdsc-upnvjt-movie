package com.dsc.movie.Fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import com.dsc.movie.Adapter.RecyclerViewAdapter
import com.dsc.movie.Model.Movie
import com.dsc.movie.R
import com.dsc.movie.Util.Url
import org.json.JSONObject

class UpcomingMovie: Fragment() {

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
        val view = inflater.inflate(R.layout.fragment_upcoming_movie, container, false)

        AndroidNetworking.get(Url().getUrl("upcoming"))
            .setTag("test")
            .setPriority(Priority.LOW)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject?) {
                    val jmovies = response?.getJSONArray("results")
                    for(i in 0 until jmovies!!.length()){
                        val jmovie = jmovies.getJSONObject(i)
                        Movie.add(
                            Movie(
                                jmovie.getString("original_title"),
                                Url().image_path + jmovie.getString("poster_path"),
                                jmovie.getInt("id")
                            )
                        )
                        val rv = view.findViewById<RecyclerView>(R.id.rcvUpcoming)
                        adapter = RecyclerViewAdapter()
                        rv.apply {
                            layoutManager = GridLayoutManager(context, 2)
                        }
                        rv.adapter = adapter
                        adapter.updateData(Movie)
                    }
                }

                override fun onError(error: ANError) {
                    Log.e("_error", error.errorBody + error.errorDetail)
                }
            })



        return view
    }
}