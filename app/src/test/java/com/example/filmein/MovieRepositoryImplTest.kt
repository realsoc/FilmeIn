package com.example.filmein

import com.example.filmein.data.MovieRepository
import com.example.filmein.data.MovieRepositoryImpl
import com.example.filmein.data.MoviesLocalDataSource
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class MovieRepositoryImplTest {

    private lateinit var tested: MovieRepository
    private lateinit var moviesLocalDataSource: MoviesLocalDataSource
    private lateinit var moviesFlow: MutableSharedFlow<List<Movie>>

    @Before
    fun setUp() {
        moviesLocalDataSource = mockk()
        tested = MovieRepositoryImpl(moviesLocalDataSource)
        moviesFlow = MutableSharedFlow()

        coEvery { moviesLocalDataSource.addMovie(any()) } returns Unit
        coEvery { moviesLocalDataSource.removeMovie(any()) } returns Unit
        coEvery { moviesLocalDataSource.changeWatchStatusForMovie(any(), any()) } returns Unit
        coEvery { moviesLocalDataSource.movies } returns moviesFlow
    }
    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun addMovie() = runTest {
        launch {
            val newMovie = Movie("title 1", false)
            moviesLocalDataSource.addMovie(newMovie)
        }
        advanceUntilIdle()
        coVerify { moviesLocalDataSource.addMovie(withArg {
            assertEquals("title 1", it.title)
            assertEquals(false, it.watched)
        })}
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun removeMovie() = runTest {
        launch {
            val toRemove = Movie("title 1", true)
            moviesLocalDataSource.removeMovie(toRemove)
        }
        advanceUntilIdle()
        coVerify { moviesLocalDataSource.removeMovie(withArg {
            assertEquals("title 1", it.title)
            assertEquals(true, it.watched)
        })}
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun changeWatchStatusForMovie() = runTest {
        launch {
            val movie = Movie("title 1", true)
            moviesLocalDataSource.changeWatchStatusForMovie(movie, false)
        }
        advanceUntilIdle()
        coVerify {
            moviesLocalDataSource.changeWatchStatusForMovie(
                withArg { assertEquals("title 1", it.title) },
                false)
        }
    }


    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun receivingMovies() = runTest {
        val movie1 = Movie("title 1", true)
        val movie2 = Movie("title 2", false)

        val values = mutableListOf<List<Movie>>()
        backgroundScope.launch(UnconfinedTestDispatcher(testScheduler)) {
            moviesLocalDataSource.movies.toList(values)
        }

        moviesFlow.emit(listOf(movie1))

        assertEquals(1, values.size)
        assertEquals(1, values[0].size)
        assertEquals("title 1", values[0][0].title)
        assertEquals(true, values[0][0].watched)

        moviesFlow.emit(listOf(movie2))

        assertEquals(2, values.size)
        assertEquals(1, values[1].size)
        assertEquals("title 2", values[1][0].title)
        assertEquals(false, values[1][0].watched)
    }
}