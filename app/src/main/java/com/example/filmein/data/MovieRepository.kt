package com.example.filmein.data

import com.example.filmein.Movie
import kotlinx.coroutines.flow.Flow

// While the only work on movie is a local CRUD its normal for this class to be dumb
interface MovieRepository {

    val movies: Flow<List<Movie>>

    suspend fun addMovie(movie: Movie)

    suspend fun removeMovie(movie: Movie)

    suspend fun changeWatchStatusForMovie(movie: Movie, watched: Boolean)
}

class MovieRepositoryImpl(
    private val moviesLocalDataSource: MoviesLocalDataSource
): MovieRepository {
    override val movies: Flow<List<Movie>>
        get() = moviesLocalDataSource.movies

    override suspend fun addMovie(movie: Movie) {
        moviesLocalDataSource.addMovie(movie)
    }

    override suspend fun removeMovie(movie: Movie) {
        moviesLocalDataSource.removeMovie(movie)
    }

    override suspend fun changeWatchStatusForMovie(movie: Movie, watched: Boolean) {
        moviesLocalDataSource.changeWatchStatusForMovie(movie, watched)
    }
}