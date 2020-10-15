package com.accretion.mytaskapp.ui.search_movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.accretion.mytaskapp.R
import com.accretion.mytaskapp.modal.search_movie.MovieResult
import com.accretion.mytaskapp.modal.search_movie.SearchMovieResponse
import com.accretion.mytaskapp.network.ApiResult
import com.accretion.mytaskapp.ui.adapter.MovieListAdapter
import java.util.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class SearchMoviesFragment : Fragment() {

    private var placeholder: TextView? = null

    private lateinit var observeMovies: Observer<ApiResult<SearchMovieResponse>>
    private val moviesList: ArrayList<MovieResult> = ArrayList()
    private lateinit var movieListAdapter: MovieListAdapter
    private lateinit var viewModel: SearchMoviesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search_movies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(SearchMoviesViewModel::class.java)
        initUI()
        initObservers()
    }

    private fun initObservers() {
        observeMovies = Observer<ApiResult<SearchMovieResponse>> { moviesData ->
            when (moviesData) {
                is ApiResult.Success -> {
                    moviesList.clear()
                    moviesList.addAll(moviesData.data.results)
                    movieListAdapter.notifyDataSetChanged()
                    if (moviesData.data.results.isEmpty()) {
                        placeholder?.visibility = View.VISIBLE
                    } else {
                        placeholder?.visibility = View.GONE
                    }
                }
                is ApiResult.Error -> {
                    moviesList.clear()
                    movieListAdapter.notifyDataSetChanged()
                    placeholder?.visibility = View.VISIBLE
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

    private fun initUI() {
        placeholder = view?.findViewById(R.id.placeHolder)
        val editTextSearch: EditText? = view?.findViewById(R.id.searchEditText)
        editTextSearch?.addTextChangedListener {
            viewModel.searchMovies(1, it.toString())
        }

        val recyclerViewMovies = view?.findViewById<RecyclerView>(R.id.recyclerViewMovies)
        recyclerViewMovies?.layoutManager = LinearLayoutManager(context)
        movieListAdapter = MovieListAdapter(this.moviesList)
        recyclerViewMovies?.adapter = movieListAdapter
    }
}