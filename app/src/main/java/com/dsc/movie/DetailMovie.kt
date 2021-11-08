package com.dsc.movie

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import com.bumptech.glide.Glide
import com.dsc.movie.Adapter.RecyclerViewAdapter
import com.dsc.movie.Model.Movie
import com.dsc.movie.Util.Url
import kotlinx.android.synthetic.main.activity_detail_movie.*
import org.json.JSONObject
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class DetailMovie : AppCompatActivity() {


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

        mTitle.text = title
        Glide
            .with(this)
            .load(img)
            .centerCrop()
            .into(mSmallPoster)
        AndroidNetworking.get(Url().getUrl(Id.toString()))
            .setTag("test")
            .setPriority(Priority.LOW)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject?) {
                    mDesc.text = response!!.getString("overview")
                    mDate.text = response.getString("release_date")
                    mRate.text = response.getString("vote_average")
                    mDuration.text = response.getString("runtime") + " menit"
                    Glide
                        .with(applicationContext)
                        .load(Url().image_path + response.getString("backdrop_path"))
                        .centerCrop()
                        .into(mPoster)
                }

                override fun onError(error: ANError) {
                    Log.e("_error", error.errorBody + error.errorDetail)
                }
            })

    }
    override fun onSupportNavigateUp(): Boolean {
        //menutup activity
         finish()
        return true
    }

}