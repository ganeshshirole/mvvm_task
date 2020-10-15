package com.accretion.mytaskapp.ui.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.accretion.mytaskapp.R
import com.accretion.mytaskapp.modal.now_playing.NowPlayingResponse
import com.accretion.mytaskapp.modal.search_movie.MovieResult
import com.accretion.mytaskapp.network.ApiResult
import com.accretion.mytaskapp.ui.adapter.Callback
import com.accretion.mytaskapp.ui.adapter.MovieListAdapter

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class MoviesFragment : Fragment(), Callback {

    private lateinit var movieListAdapter: MovieListAdapter
    private var moviesList: ArrayList<MovieResult> = ArrayList()
    private lateinit var observeMovies: Observer<ApiResult<NowPlayingResponse>>
    private lateinit var viewModel: MoviesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(MoviesViewModel::class.java)
        initObservers()
        initUI()
        viewModel.nowPlaying(1)
    }

    private fun initUI() {
        val searchScreenButton = view?.findViewById<Button>(R.id.buttonSearchScreen)
        searchScreenButton?.setOnClickListener {
            findNavController().navigate(R.id.action_MoviesFragment_to_searchMoviesFragment)
        }

        val recyclerViewMovies = view?.findViewById<RecyclerView>(R.id.recyclerViewMovies)

        recyclerViewMovies?.layoutManager = LinearLayoutManager(context)
        movieListAdapter = MovieListAdapter(this.moviesList, this)
        recyclerViewMovies?.adapter = movieListAdapter
    }

    private fun initObservers() {
        observeMovies = Observer<ApiResult<NowPlayingResponse>> { moviesData ->
            when (moviesData) {
                is ApiResult.Success -> {
                    moviesList.addAll(moviesData.data.results)
                    movieListAdapter.notifyDataSetChanged()
                }
                is ApiResult.Error -> {
                    Toast.makeText(
                        requireContext(),
                        getString(R.string.something_went_wrong),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
        viewModel.moviesLiveData.observe(viewLifecycleOwner, observeMovies)
    }

    override fun onClick(position: Int) {
        val bundle = Bundle()
        bundle.putParcelable("movie", moviesList[position])
        findNavController().navigate(R.id.action_MoviesFragment_to_DetailsFragment, bundle)
    }
}