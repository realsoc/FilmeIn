package com.example.filmein.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.filmein.Movie
import com.example.filmein.data.MovieRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

typealias ListUiState = List<Movie>

/**
 * FilmeScreen ViewModel
 *
 * Responsible for the dialog state
 */
class FilmeScreenViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    val movieListState: StateFlow<ListUiState> = movieRepository.movies.map {
        it.distinctBy(Movie::title).sortedBy(Movie::watched)
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.Eagerly,
        initialValue = listOf()
    )

    private var _dialogState = MutableStateFlow(false)
    val dialogState: StateFlow<Boolean> = _dialogState.asStateFlow()

    private suspend fun addMovie(title: String) {
        movieRepository.addMovie(Movie(title, false))
    }

    private suspend fun removeMovie(movie: Movie) {
        movieRepository.removeMovie(movie)
    }

    private suspend fun changeWatchStatusForMovie(movie: Movie, watched: Boolean) {
        movieRepository.changeWatchStatusForMovie(movie, watched)
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

    fun eyeToggled(movie: Movie) {
        viewModelScope.launch {
            changeWatchStatusForMovie(movie, !movie.watched)
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