package com.example.filmein.ui

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsFocused
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.hasContentDescription
import androidx.compose.ui.test.hasParent
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.compose.ui.test.performTouchInput
import androidx.compose.ui.test.swipeRight
import com.example.filmein.Movie
import io.mockk.Runs
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.junit4.MockKRule
import io.mockk.just
import io.mockk.verify
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class FilmeScreenTest {

    @MockK
    lateinit var viewModel: FilmeScreenViewModel

    private lateinit var shouldShowDialogFlow: MutableStateFlow<Boolean>

    private lateinit var movieListStateFlow: MutableStateFlow<ListUiState>

    @get:Rule
    val mockkRule = MockKRule(this)

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setUp() {
        shouldShowDialogFlow = MutableStateFlow(false)
        every {
            viewModel.dialogState
        } returns shouldShowDialogFlow.asStateFlow()

        movieListStateFlow = MutableStateFlow(listOf<Movie>())
        every {
            viewModel.movieListState
        } returns movieListStateFlow.asStateFlow()

        every { viewModel.addMovieClicked() } just Runs
        every { viewModel.dismissDialog() } just Runs
        every { viewModel.movieSwipedRight(any()) } just Runs
        every { viewModel.submitDialog(any()) } just Runs
        every { viewModel.eyeToggled(any()) } just Runs

        composeTestRule.setContent {
            FilmeScreen(viewModel = viewModel)
        }
    }
    @Test
    fun clickOnAddMovieCallVm() {
        composeTestRule.onNodeWithContentDescription("Add movie").performClick()

        verify {
            viewModel.addMovieClicked()
        }
    }

    @Test
    fun movieListUi() {
        composeTestRule.onNodeWithText("movie1").assertDoesNotExist()
        composeTestRule.onNodeWithText("movie2").assertDoesNotExist()

        movieListStateFlow.update { listOf(Movie("movie1"), Movie("movie2")) }

        composeTestRule.onNodeWithText("movie1").assertIsDisplayed()
        composeTestRule.onNodeWithText("movie2").assertIsDisplayed()
    }

    @Test
    fun dialogUi() {
        composeTestRule.onNodeWithText("Add Movie / TV Show").assertDoesNotExist()

        shouldShowDialogFlow.update { true }

        composeTestRule.onNodeWithText("Add Movie / TV Show").assertIsDisplayed()

        composeTestRule.onNodeWithTag("dialog text field").assertTextContains("")
    }
    @Test
    fun removeMovieCallVm() {
        movieListStateFlow.update { listOf(Movie("movie1"), Movie("movie2")) }

        composeTestRule.onNodeWithText("movie1").performTouchInput { swipeRight() }

        verify {
            viewModel.movieSwipedRight(match { it.title == "movie1" })
        }
    }

    @Test
    fun switchWatchStatusCallVm() {
        movieListStateFlow.update { listOf(Movie("movie1"), Movie("movie2")) }

        composeTestRule.onNode(hasParent(hasText("movie1")).and(hasContentDescription("switch watched status"))).performClick()

        verify {
            viewModel.eyeToggled(match { it.title == "movie1" })
        }
    }

    @Test
    fun writingTextAndClickingDismissDoNotCallVm() {
        shouldShowDialogFlow.update { true }

        composeTestRule.onNodeWithTag("dialog text field").performTextInput("My new movie")

        composeTestRule.onNodeWithText("Dismiss").performClick()

        verify(exactly = 0) {
            viewModel.submitDialog(any())
        }
    }

    @Test
    fun writingTextAndClickingOkCallVm() {
        shouldShowDialogFlow.update { true }

        composeTestRule.onNodeWithTag("dialog text field").performTextInput("My new movie")

        composeTestRule.onNodeWithText("Ok").performClick()

        verify {
            viewModel.submitDialog(eq("My new movie"))
        }
    }

    @Test
    fun dialogHasFocusWhenOpen() {
        shouldShowDialogFlow.update { true }

        composeTestRule.onNodeWithTag("dialog text field").assertIsFocused()
    }
}