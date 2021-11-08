package com.dsc.movie.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dsc.movie.DetailMovie
import com.dsc.movie.Model.Movie
import com.dsc.movie.R


class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder>() {

    private var onMovieItemClickedListener: OnMovieItemClickedListener? = null
    private val item = mutableListOf<Movie>()

    class RecyclerViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        fun bindItem(item: Movie) = with(view) {
            val mTitle = itemView.findViewById<TextView>(R.id.txtTitle)
            val mPoster = itemView.findViewById<ImageView>(R.id.filmPoster)

            //image
            Glide
                .with(view)
                .load(item.img)
                .centerCrop()
                .into(mPoster)

            mTitle.text = item.title

            view.setOnClickListener {
                val intent = Intent(context, DetailMovie::class.java)
                intent.putExtra("title", item.title)
                intent.putExtra("img", item.img)
                intent.putExtra("Id", item.Id.toString())

                context.startActivity(intent)
            }
        }
    }

    @NonNull
    override fun onCreateViewHolder(@NonNull parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.content_movie, parent, false)
        return RecyclerViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.view.setOnClickListener { onMovieItemClickedListener!!.onMovieItemClicked(item[position]) }
        holder.bindItem(item[position])
    }

    override fun getItemCount() = item.size

    fun updateData(newItems: MutableList<Movie>) {
        item.clear()
        item.addAll(newItems)
        notifyDataSetChanged()
    }

    interface OnMovieItemClickedListener {
        fun onMovieItemClicked(movie: Movie)
    }

}
