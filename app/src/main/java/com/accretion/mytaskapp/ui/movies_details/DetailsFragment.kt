package com.accretion.mytaskapp.ui.movies_details

import android.media.Image
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.accretion.mytaskapp.R
import com.accretion.mytaskapp.modal.search_movie.MovieResult
import com.accretion.mytaskapp.ui.adapter.Callback
import com.bumptech.glide.Glide

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class DetailsFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val movie: MovieResult? = arguments?.getParcelable("movie")
        initUI(movie)
    }

    private fun initUI(movie : MovieResult?) {
        val textViewTitle = view?.findViewById<TextView>(R.id.textViewTitle)
        val textViewDescription = view?.findViewById<TextView>(R.id.textViewDescription)
        val imageViewMovie = view?.findViewById<ImageView>(R.id.imageViewMovie)
        val ratingBar = view?.findViewById<RatingBar>(R.id.ratingBar)

        textViewTitle?.text = movie?.title
        textViewDescription?.text = movie?.overview
        ratingBar?.rating = (movie?.vote_average ?: 0.0).toFloat()

        Glide
            .with(requireContext())
            .load("https://image.tmdb.org/t/p/w185/${movie?.poster_path}")
            .centerCrop()
            .placeholder(R.drawable.placeholder)
            .into(imageViewMovie!!)
    }


}