package com.example.filmein

import com.example.filmein.data.MovieRepository
import com.example.filmein.ui.FilmeScreenViewModel
import com.example.filmein.ui.ListUiState
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class FilmeScreenViewModelTest {

    private lateinit var movieEmitter: MutableSharedFlow<List<Movie>>
    private lateinit var mockedRepository: MovieRepository
    private lateinit var testedVm: FilmeScreenViewModel

    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()

    @Before
    fun setUp() {
        movieEmitter = MutableSharedFlow()
        mockedRepository = mockk()

        coEvery { mockedRepository.addMovie(any()) } returns Unit
        coEvery { mockedRepository.removeMovie(any()) } returns Unit
        coEvery { mockedRepository.changeWatchStatusForMovie(any(), any()) } returns Unit
        coEvery { mockedRepository.movies } returns movieEmitter

        testedVm = FilmeScreenViewModel(mockedRepository)
    }

    @Test
    fun initialState() = runTest {
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

    @Test
    fun transmittingMovies() = runTest {
        val moviesStates = mutableListOf<ListUiState>()

        backgroundScope.launch(UnconfinedTestDispatcher(testScheduler)) {
            testedVm.movieListState.toList(moviesStates)
        }

        assertEquals(1, moviesStates.size)
        assertEquals(0, moviesStates[0].size)

        val movie1 = Movie("Movie1", false)
        val movie2 = Movie("Movie2", false)

        movieEmitter.emit(listOf(movie1, movie2))

        assertEquals(2, moviesStates.size)
        assertEquals(2, moviesStates[1].size)
    }

    @Test
    fun addMovie() = runTest {
        val moviesStates = mutableListOf<ListUiState>()

        backgroundScope.launch(UnconfinedTestDispatcher(testScheduler)) {
            testedVm.movieListState.toList(moviesStates)
        }

        testedVm.submitDialog("Movie to add")

        coVerify { mockedRepository.addMovie(match {
            it.title == "Movie to add" && !it.watched
        }) }
    }

    @Test
    fun removeMovie() = runTest {
        val moviesStates = mutableListOf<ListUiState>()

        val movie = Movie("Movie1", false)

        movieEmitter.emit(listOf(movie))

        backgroundScope.launch(UnconfinedTestDispatcher(testScheduler)) {
            testedVm.movieListState.toList(moviesStates)
        }

        assertEquals(1, moviesStates.size)
        assertEquals(1, moviesStates[0].size)
        assertEquals("Movie1", movie.title)

        testedVm.movieSwipedRight(movie)

        coVerify { mockedRepository.removeMovie(movie) }
    }

    @Test
    fun showDialog() = runTest {
        val dialogStates = mutableListOf<Boolean>()

        backgroundScope.launch(UnconfinedTestDispatcher(testScheduler)) {
            testedVm.dialogState.toList(dialogStates)
        }

        testedVm.addMovieClicked()

        assertEquals(2, dialogStates.size)
        assertEquals(true, dialogStates[1])
    }


    @Test
    fun dismissDialog() = runTest {
        val dialogStates = mutableListOf<Boolean>()

        backgroundScope.launch(UnconfinedTestDispatcher(testScheduler)) {
            testedVm.dialogState.toList(dialogStates)
        }

        testedVm.dismissDialog()

        assertEquals(1, dialogStates.size)

        testedVm.addMovieClicked()
        testedVm.dismissDialog()

        assertEquals(3, dialogStates.size)
        assertEquals(false, dialogStates[2])
    }


    @Test
    fun changeStatusOfMovie() = runTest {
        val moviesStates = mutableListOf<ListUiState>()

        val movie = Movie("Movie1", false)

        movieEmitter.emit(listOf(movie))

        backgroundScope.launch(UnconfinedTestDispatcher(testScheduler)) {
            testedVm.movieListState.toList(moviesStates)
        }

        assertEquals(1, moviesStates.size)
        assertEquals(1, moviesStates[0].size)

        assertEquals(false, movie.watched)

        testedVm.eyeToggled(movie)

        coVerify { mockedRepository.changeWatchStatusForMovie(movie, true) }
    }
}