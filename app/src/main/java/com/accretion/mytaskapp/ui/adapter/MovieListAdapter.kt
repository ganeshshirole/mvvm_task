package com.accretion.mytaskapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.accretion.mytaskapp.R
import com.accretion.mytaskapp.modal.search_movie.MovieResult
import com.bumptech.glide.Glide

class MovieListAdapter(
    private val items: ArrayList<MovieResult>
) :
    RecyclerView.Adapter<ViewHolder>() {

    // Gets the number of animals in the list
    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_movie,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = items[position]
        holder.titleText.text = movie.title
        holder.textViewDescription.text = movie.overview
        holder.ratingBar.rating = movie.vote_average.toFloat()

        Glide
            .with(holder.imageView.context)
            .load("https://image.tmdb.org/t/p/w185/${movie.poster_path}")
            .centerCrop()
            .placeholder(R.drawable.placeholder)
            .into(holder.imageView);
    }
}

class ViewHolder(// Holds the TextView that will add each animal to
    private val view: View
) : RecyclerView.ViewHolder(view) {
    val titleText: TextView = view.findViewById(R.id.textViewTitle)
    val textViewDescription: TextView = view.findViewById(R.id.textViewDescription)
    val imageView: ImageView = view.findViewById(R.id.imageView)
    val ratingBar: RatingBar = view.findViewById(R.id.ratingBar2)
}
