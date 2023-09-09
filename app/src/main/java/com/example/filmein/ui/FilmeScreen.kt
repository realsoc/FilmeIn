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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.tooling.preview.Preview
import com.example.filmein.FilmeScreenViewModel
import com.example.filmein.ifTrue

@Composable
@Preview
fun FilmeScreenPreview() {
    FilmeScreen(viewModel = FilmeScreenViewModel())
}
@Composable
fun FilmeScreen(viewModel: FilmeScreenViewModel) {
    val movies by viewModel.movieListState.collectAsState()
    val shouldShowDialog by viewModel.dialogState.collectAsState()

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

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { viewModel.addMovieClicked() },
                content = { Icon(Icons.Default.Add,
                    modifier = Modifier.scale(movies.isEmpty().ifTrue { scale } ?: 1F),
                    contentDescription = "Add movie") }
            )
        },
        content = { paddingValues ->
            if (shouldShowDialog) {
                var dialogText by remember { mutableStateOf("") }
                EnterTextDialog(
                    title = { Text(text = "Add Movie / TV Show") },
                    dismissButton = {
                        TextButton(
                            onClick = viewModel::dismissDialog,
                            content = { Text("Dismiss") }
                        )
                    },
                    confirmButton = {
                        TextButton(
                            onClick = {
                                if (dialogText != "") {
                                    viewModel.submitDialog(dialogText)
                                }
                                viewModel.dismissDialog() },
                            content = { Text("Ok") }
                        )
                    },
                    hint = { Text("Title") },
                    value = dialogText,
                    onNewText = { newText -> dialogText = newText },
                    onDismissRequest = viewModel::dismissDialog,
                )
            }
            MovieList(
                paddingValues = paddingValues,
                movies = movies,
                onMovieDeleted = viewModel::movieSwipedRight,
                onWatchedStatusChangeForMovie = viewModel::eyeToggled
            )
        })
}