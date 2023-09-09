package com.example.filmein

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

typealias ListUiState = List<Movie>

class FilmeScreenViewModel : ViewModel() {

    private val _movieListState = MutableStateFlow<ListUiState>(mutableListOf())
    val movieListState: StateFlow<ListUiState> = _movieListState.asStateFlow()

    private var _dialogState = MutableStateFlow(false)
    val dialogState: StateFlow<Boolean> = _dialogState.asStateFlow()

    private fun addMovie(title: String) {
        val movies = _movieListState.value.toMutableList()
        // If movie already in list go 1st position
        movies.removeAll { it.title == title }
        movies.add(0, Movie(title))
        _movieListState.value = movies
    }

    private fun removeMovie(movie: Movie) {
        val movies = _movieListState.value.toMutableList()
        movies.remove(movie)
        _movieListState.value = movies
    }

    private fun changeWatchStatusForMovie(movie: Movie, watched: Boolean) {
        val movies = _movieListState.value.toMutableList()
        val movieIdx = movies.indexOf(movie)
        if (movieIdx < 0) return

        movies.remove(movie)
        movies.add(movieIdx, Movie(movie.title, watched))
        _movieListState.value = movies
    }
    fun submitDialog(title: String) {
        viewModelScope.launch {
            addMovie(title)
        }
    }

    fun movieSwipedRight(movie: Movie) {
        viewModelScope.launch {
            removeMovie(movie)
        }
    }

    fun eyeToggled(movie: Movie, open: Boolean) {
        viewModelScope.launch {
            changeWatchStatusForMovie(movie, open)
        }
    }

    fun dismissDialog() {
        viewModelScope.launch {
            _dialogState.value = false
        }
    }

    fun addMovieClicked() {
        viewModelScope.launch {
            _dialogState.value = true
        }
    }
}