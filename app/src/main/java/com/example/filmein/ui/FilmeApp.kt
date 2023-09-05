package com.example.filmein.ui

import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.tooling.preview.Preview
import com.example.filmein.Movie

@Composable
@Preview
fun FilmeApp() {
    val movies = remember { mutableStateListOf<Movie>() }
    var text by remember { mutableStateOf("") }
    var shouldShowDialog by remember { mutableStateOf(false) }
    val infiniteTransition = rememberInfiniteTransition("InfiniteTransition")
    val scale by infiniteTransition.animateFloat(
        initialValue = 0.9f,
        targetValue = 1.1f,
        animationSpec = infiniteRepeatable(
            animation = tween(800, easing = FastOutLinearInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "ScaleTransition"
    )

    val onNewText: (String) -> Unit = { newText -> text = newText }
    val onHideDialog = { shouldShowDialog = false }
    val onDialogDismissed = {
        onHideDialog()
        text = ""
    }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { shouldShowDialog = true },
                content = { Icon(Icons.Default.Add,
                    modifier = Modifier.scale(movies.isEmpty().ifTrue { scale } ?: 1F),
                    contentDescription = "Add movie") }
            )
        },
        content = { paddingValues ->
            if (shouldShowDialog) {
                EnterTextDialog(
                    // TODO extract text
                    title = { Text(text = "Movie / TV Show") },
                    dismissButton = {
                        TextButton(
                            onClick = onDialogDismissed,
                            content = { Text("Dismiss") }
                        )
                    },
                    confirmButton = {
                        TextButton(
                            onClick = {
                                if (text != "") {
                                    movies.remove(Movie(text))
                                    movies.add(0, Movie(text))
                                }
                                onDialogDismissed() },
                            content = { Text("Ok") }
                        )
                    },
                    hint = { Text("Title") },
                    value = text,
                    onNewText = onNewText,
                    onDismissRequest = onDialogDismissed
                )
            }
            MovieList(
                paddingValues = paddingValues,
                movies = movies,
                onMovieDeleted = movies::remove,
                onWatchedStatusChangeForMovie = movies::onWatchStatusChangeForMovie
            )
        })
}

fun SnapshotStateList<Movie>.onWatchStatusChangeForMovie(movie: Movie, watched: Boolean) {
    val movieIndex = indexOf(movie)
    if (movieIndex >= 0) {
        remove(movie)
        add(movieIndex, Movie(movie.title, watched))
    }
}

fun <T>Boolean.ifTrue(block: () -> T): T? {
    return if (this) {
        block.invoke()
    } else {
        null
    }
}