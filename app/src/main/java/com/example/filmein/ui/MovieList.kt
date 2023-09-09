package com.example.filmein.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.DismissDirection
import androidx.compose.material3.DismissValue
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.SwipeToDismiss
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDismissState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.filmein.Movie
import com.example.filmein.R

data class DismissBehavior(val onDismiss: (movie: Movie) -> Unit, val background: DismissBackground)
data class DismissBackground(val color: Color, val icon: ImageVector)

val deletingMovieBackground = DismissBackground(Color.Red, Icons.Default.Delete)

@Composable
fun EmptyList(modifier: Modifier) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.movie_animation))

    LottieAnimation(
        modifier = modifier,
        composition = composition,
        iterations = LottieConstants.IterateForever,
    )
}


@Composable
fun MovieList(
    paddingValues: PaddingValues,
    movies: List<Movie>,
    onMovieDeleted: ((movie: Movie) -> Unit),
    onWatchedStatusChangeForMovie: (movie: Movie, watched: Boolean) -> Unit
) {
    // Create a MutableTransitionState<Boolean> for the AnimatedVisibility.
    val state = remember {
        MutableTransitionState(false).apply {
            // Start the animation immediately.
            targetState = true
        }
    }

    // Placeholder or movie list
    if (movies.isEmpty()) {
        AnimatedVisibility(
            visibleState = state,
            enter = fadeIn(animationSpec = tween(3000))
        ) {
            EmptyList(modifier = Modifier.fillMaxSize())
        }
    } else {
        LazyColumn(modifier = Modifier.padding(paddingValues)) {
            showMovieListIfNotEmpty(
                movies = movies,
                title = null,
                swipeRightDismissBehavior = DismissBehavior(onMovieDeleted, deletingMovieBackground),
                swipeLeftDismissBehavior = null,
                onWatchStatusChangeForMovie = onWatchedStatusChangeForMovie
            )
        }
    }
}

fun onWatchStatusChangeForMovie(
    movie: Movie,
    onStatusChange: (movie: Movie, yo: Boolean) -> Unit
): (watched: Boolean) -> Unit {
    return { watched: Boolean -> onStatusChange(movie, watched) }
}

@OptIn(ExperimentalMaterial3Api::class)
fun createDismissDirectionSet(
    startToEndDismissBehavior: DismissBehavior?,
    endToStartDismissBehavior: DismissBehavior?
): Set<DismissDirection> {
    return mutableSetOf<DismissDirection>().apply {
        if (startToEndDismissBehavior != null) add(DismissDirection.StartToEnd)
        if (endToStartDismissBehavior != null) add(DismissDirection.EndToStart)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
fun LazyListScope.showMovieListIfNotEmpty(
    movies: List<Movie>,
    title: String?,
    swipeRightDismissBehavior: DismissBehavior?,
    swipeLeftDismissBehavior: DismissBehavior?,
    onWatchStatusChangeForMovie: (movie: Movie, watched: Boolean) -> Unit
) {
    if (movies.isEmpty()) {
        return
    }

    items(
        items = movies,
        key = { s -> "$title$s" }
    ) { movie ->
        val dismissState = rememberDismissState(
            confirmValueChange = {
                when (it) {
                    DismissValue.Default -> {}
                    DismissValue.DismissedToStart -> swipeLeftDismissBehavior?.onDismiss?.invoke(movie)
                    DismissValue.DismissedToEnd -> swipeRightDismissBehavior?.onDismiss?.invoke(movie)
                }
                return@rememberDismissState false
            }
        )
        val dismissDirections = createDismissDirectionSet(swipeRightDismissBehavior, swipeLeftDismissBehavior)
        SwipeToDismiss(
            state = dismissState,
            directions = dismissDirections,
            background = {

                val direction = dismissState.dismissDirection ?: return@SwipeToDismiss
                if (dismissDirections.contains(direction).not()) return@SwipeToDismiss

                val activeBackground = when (direction) {
                    DismissDirection.StartToEnd -> swipeRightDismissBehavior?.background
                    DismissDirection.EndToStart -> swipeLeftDismissBehavior?.background
                }
                val backgroundColor = when (dismissState.targetValue) {
                    DismissValue.Default -> Color.LightGray
                    else -> activeBackground!!.color
                }

                val color by animateColorAsState(backgroundColor, label = "")

                val alignment = when (direction) {
                    DismissDirection.StartToEnd -> Alignment.CenterStart
                    DismissDirection.EndToStart -> Alignment.CenterEnd
                }
                val scale by animateFloatAsState(
                    if (dismissState.targetValue == DismissValue.Default) 0.75f else 1f, label = ""
                )

                Box(
                    Modifier
                        .fillMaxSize()
                        .background(color)
                        .padding(horizontal = 20.dp),
                    contentAlignment = alignment
                ) {
                    Icon(
                        activeBackground!!.icon,
                        contentDescription = "Localized description",
                        modifier = Modifier.scale(scale)
                    )
                }
            },
            dismissContent = {
                MovieTile(
                    movie = movie,
                    onWatchStatusChange = onWatchStatusChangeForMovie(movie, onWatchStatusChangeForMovie)
                )
            }
        )
    }
}


@Composable
fun MovieTile(movie: Movie, onWatchStatusChange: (watched: Boolean) -> Unit) {
    Column {
        ListItem(
            modifier = Modifier
                .clickable { println("${movie.title} clicked") }
                .testTag("listItem"),
            headlineContent = { Text(movie.title) },
            trailingContent = {
                IconButton(
                    onClick = { onWatchStatusChange(!movie.watched) },
                    content = {
                        Icon(
                            movie.getWatchStatusDrawable(), "switch watched status", tint = Color
                                .Unspecified
                        )
                    })
            }
        )
        Divider(color = Color.LightGray)
    }
}