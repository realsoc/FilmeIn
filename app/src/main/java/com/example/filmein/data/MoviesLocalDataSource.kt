package com.example.filmein.data

import androidx.datastore.core.DataStore
import com.example.filmein.Movie
import com.example.filmein.MovieProto
import com.example.filmein.MoviesProto
import kotlinx.coroutines.flow.Flow

interface MoviesLocalDataSource {
    val movies: Flow<List<Movie>>
    suspend fun addMovie(movie: Movie)
    suspend fun removeMovie(movie: Movie)
    suspend fun changeWatchStatusForMovie(movie: Movie, watched: Boolean)
}

class MoviesLocalDataSourceImpl(
    private val moviesDataStore: DataStore<MoviesProto>
): MoviesLocalDataSource {
    override val movies: Flow<List<Movie>>
        get() = moviesDataStore.movieListFlow()

    override suspend fun addMovie(movie: Movie) {
        changeDb { db ->
            if (!db.movieProtoList.contains(movie)) {
                db.toBuilder()
                    .addMovieProto(
                        0,
                        MovieProto.newBuilder()
                            .setTitle(movie.title)
                            .setWatched(movie.watched).build()
                    ).build()
            } else db
        }
    }

    override suspend fun removeMovie(movie: Movie) {
        changeDb { db ->
            val index = db.movieProtoList.indexOf(movie)
            if (index >= 0) {
                db.toBuilder().removeMovieProto(index).build()
            } else db
        }
    }

    override suspend fun changeWatchStatusForMovie(movie: Movie, watched: Boolean) {
        changeDb { db ->
            val index = db.movieProtoList.indexOf(movie)
            if (index >= 0) {
                val movieUpdated = db.getMovieProto(index).toBuilder().setWatched(watched).build()
                db.toBuilder().setMovieProto(index, movieUpdated).build()
            } else db
        }
    }

    private suspend fun changeDb(callback: (db: MoviesProto) -> MoviesProto) {
        moviesDataStore.updateData(callback)
    }
}