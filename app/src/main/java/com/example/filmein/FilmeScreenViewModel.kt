package com.example.filmein

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class FilmeScreenViewModel(
) : ViewModel() {

    private val _movieListState = MutableStateFlow<ListUiState>(mutableListOf())
    val movieListState: StateFlow<ListUiState> = _movieListState.asStateFlow()

    private var _dialogState = MutableStateFlow(false)
    val dialogState: StateFlow<Boolean> = _dialogState.asStateFlow()

    fun addMovie(title: String) {
        val movies = _movieListState.value.toMutableList()
        movies.removeAll { it.title == title }
        movies.add(0, Movie(title))
        _movieListState.update { movies }
    }

    fun removeMovie(movie: Movie) {
        val movies = _movieListState.value.toMutableList()
        movies.remove(movie)
        _movieListState.update { movies }
    }

    fun changeWatchStatusForMovie(movie: Movie, watched: Boolean) {
        val movies = _movieListState.value.toMutableList()
        val movieIdx = movies.indexOf(movie)
        if (movieIdx < 0) return

        movies.remove(movie)
        movies.add(movieIdx, Movie(movie.title, watched))
        _movieListState.update { movies }
    }

    fun dismissDialog() {
        _dialogState.update { false }
    }

    fun showDialog() {
        _dialogState.update { true }
    }
}

typealias ListUiState = List<Movie>
