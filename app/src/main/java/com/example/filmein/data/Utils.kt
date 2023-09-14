package com.example.filmein.data

import androidx.datastore.core.DataStore
import com.example.filmein.Movie
import com.example.filmein.MovieProto
import com.example.filmein.MoviesProto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

fun MovieProto.toMovie(): Movie {
    return Movie(title, watched)
}

fun List<MovieProto>.indexOf(movie: Movie): Int {
    return indexOfFirst { it.title == movie.title }
}

fun List<MovieProto>.contains(movie: Movie): Boolean {
    return indexOf(movie) != -1
}

fun transformToMovieList(movieProtoList: List<MovieProto>): List<Movie> = movieProtoList.map { it.toMovie() }

fun DataStore<MoviesProto>.movieProtoListFlow(): Flow<List<MovieProto>> = data.map { it.movieProtoList }

fun DataStore<MoviesProto>.movieListFlow(): Flow<List<Movie>> = movieProtoListFlow().map(::transformToMovieList)
