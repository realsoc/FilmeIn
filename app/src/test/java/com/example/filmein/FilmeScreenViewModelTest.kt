package com.example.filmein

import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class FilmeScreenViewModelTest {
    private lateinit var testedVm: FilmeScreenViewModel

    @Before
    fun setUp() {
        testedVm = FilmeScreenViewModel()
    }

    @Test
    fun init() {
        runTest {
            val moviesStates = mutableListOf<ListUiState>()
            val dialogStates = mutableListOf<Boolean>()
            backgroundScope.launch(UnconfinedTestDispatcher(testScheduler)) {
                testedVm.movieListState.toList(moviesStates)
            }

            backgroundScope.launch(UnconfinedTestDispatcher(testScheduler)) {
                testedVm.dialogState.toList(dialogStates)
            }

            assertEquals(1, moviesStates.size)
            assert(moviesStates[0].isEmpty())
            assertEquals(1, dialogStates.size)
            assert(!dialogStates[0])
        }
    }

    @Test
    fun addMovie() {
        runTest {
            val moviesStates = mutableListOf<ListUiState>()
            backgroundScope.launch(UnconfinedTestDispatcher(testScheduler)) {
                testedVm.movieListState.toList(moviesStates)
            }

            testedVm.addMovie("Movie to add")

            assertEquals(2, moviesStates.size)
            assertEquals(1, moviesStates[1].size)
            assertEquals("Movie to add", moviesStates[1].first().title)
        }
    }

    @Test
    fun removeMovie() {
        runTest {
            val moviesStates = mutableListOf<ListUiState>()
            val dialogStates = mutableListOf<Boolean>()

            testedVm.addMovie("Movie1")
            testedVm.addMovie("Movie2")

            backgroundScope.launch(UnconfinedTestDispatcher(testScheduler)) {
                testedVm.movieListState.toList(moviesStates)
            }

            assertEquals(1, moviesStates.size)
            assertEquals(2, moviesStates[0].size)

            val movie = moviesStates.first()[0]

            assertEquals("Movie2", movie.title)

            testedVm.removeMovie(movie)

            assertEquals(2, moviesStates.size)

            assertEquals(1, moviesStates[1].size)

            assertEquals("Movie1", moviesStates[1].first().title)
        }
    }

    @Test
    fun showDialog() {
        runTest {
            val dialogStates = mutableListOf<Boolean>()

            backgroundScope.launch(UnconfinedTestDispatcher(testScheduler)) {
                testedVm.dialogState.toList(dialogStates)
            }

            testedVm.showDialog()

            assertEquals(2, dialogStates.size)
            assertEquals(true, dialogStates[1])
        }
    }

    @Test
    fun dismissDialog() {
        runTest {
            val dialogStates = mutableListOf<Boolean>()

            backgroundScope.launch(UnconfinedTestDispatcher(testScheduler)) {
                testedVm.dialogState.toList(dialogStates)
            }

            testedVm.dismissDialog()

            assertEquals(1, dialogStates.size)

            testedVm.showDialog()
            testedVm.dismissDialog()

            assertEquals(3, dialogStates.size)
            assertEquals(false, dialogStates[2])
        }
    }

    @Test
    fun changeStatusOfMovie() {
        runTest {
            val moviesStates = mutableListOf<ListUiState>()

            testedVm.addMovie("Movie1")

            backgroundScope.launch(UnconfinedTestDispatcher(testScheduler)) {
                testedVm.movieListState.toList(moviesStates)
            }

            assertEquals(1, moviesStates.size)
            assertEquals(1, moviesStates[0].size)

            val movie = moviesStates[0].first()

            assertEquals(false, movie.watched)

            testedVm.changeWatchStatusForMovie(movie, true)

            assertEquals(2, moviesStates.size)
            assertEquals(1, moviesStates[1].size)

            val newMovie = moviesStates[1].first()

            assertEquals(movie.title, newMovie.title)
            assertEquals(true, newMovie.watched)
        }
    }
}