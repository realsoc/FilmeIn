package com.example.filmein.ui

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.DataStoreFactory
import androidx.datastore.dataStoreFile
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.filmein.Movie
import com.example.filmein.data.MoviesLocalDataSource
import com.example.filmein.data.MoviesLocalDataSourceImpl
import com.example.filmein.MoviesProto
import com.example.filmein.data.MoviesSerializer
import com.example.filmein.data.movieListFlow
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.File

private const val TEST_MOVIES_DATASTORE_NAME: String = "test_movies_datastore"

@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(AndroidJUnit4::class)
class MoviesLocalDataSourceImplTest {

    private val testContext: Context = InstrumentationRegistry.getInstrumentation().targetContext
    private val testCoroutineDispatcher: TestDispatcher = UnconfinedTestDispatcher()
    private val testCoroutineScope: TestScope = TestScope(testCoroutineDispatcher + Job())

    private lateinit var testDataStore: DataStore<MoviesProto>

    private lateinit var tested: MoviesLocalDataSource

    @Before
    fun setUp() {
        testDataStore  = DataStoreFactory.create(
            scope = testCoroutineScope,
            produceFile = { testContext.dataStoreFile(TEST_MOVIES_DATASTORE_NAME + Math.random().toString()) },
            serializer = MoviesSerializer
        )
        tested = MoviesLocalDataSourceImpl(testDataStore)
        Dispatchers.setMain(testCoroutineDispatcher)
    }

    @After
    fun tearDown() {
        testContext.filesDir.clean()
    }

    @Test
    fun initialMovies() = runTest {
        val initialMovies = fetchInitialMovies()
        assertEquals(0, initialMovies.size)
    }

    @Test
    fun writeMovie() = runTest {
        val values = mutableListOf<List<Movie>>()
        backgroundScope.launch(UnconfinedTestDispatcher(testScheduler)) {
            tested.movies.toList(values)
        }

        assertEquals(1, values.size)
        assertEquals(0, values[0].size)

        tested.addMovie(Movie("title", true))

        assertEquals(2, values.size)
        assertEquals(1, values[1].size)
        assertEquals("title", values[1][0].title)
        assertEquals(true, values[1][0].watched)
    }

    @Test
    fun removeMovie() = runTest {
        val values = mutableListOf<List<Movie>>()

        val movie = Movie("title", true)
        tested.addMovie(movie)

        backgroundScope.launch(UnconfinedTestDispatcher(testScheduler)) {
            tested.movies.toList(values)
        }

        assertEquals(1, values.size)
        assertEquals(1, values[0].size)
        assertEquals("title", values[0][0].title)

        tested.removeMovie(movie)

        assertEquals(2, values.size)
        assertEquals(0, values[1].size)
    }

    @Test
    fun changeWatchStatusForMovie() = runTest {
        val values = mutableListOf<List<Movie>>()

        val movie = Movie("title", true)
        tested.addMovie(movie)

        backgroundScope.launch(UnconfinedTestDispatcher(testScheduler)) {
            tested.movies.toList(values)
        }

        assertEquals(1, values.size)
        assertEquals(1, values[0].size)
        assertEquals("title", values[0][0].title)
        assertEquals(true, values[0][0].watched)

        tested.changeWatchStatusForMovie(movie, false)

        assertEquals(2, values.size)
        assertEquals(1, values[1].size)
        assertEquals("title", values[1][0].title)
        assertEquals(false, values[1][0].watched)
    }

    private suspend fun fetchInitialMovies() =
        testDataStore.movieListFlow().first()

    private fun File.clean() {
        listFiles()?.let {
            for (file in it) {
                file.deleteRecursively()
            }
        }
        delete()
    }
}