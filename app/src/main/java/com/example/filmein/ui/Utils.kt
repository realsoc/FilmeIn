package com.example.filmein.ui

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.filmein.Movie

fun Movie.getWatchStatusDrawable(): ImageVector {
    return if (watched) EyeOpen else EyeClosed
}

@Composable
fun Movie.getBgColor(): Color {
    return if (watched) MaterialTheme.colorScheme.primaryContainer else Color.White
}

@Composable
fun Movie.getDivColor(): Color {
    return if (!watched) MaterialTheme.colorScheme.primaryContainer else Color.White
}