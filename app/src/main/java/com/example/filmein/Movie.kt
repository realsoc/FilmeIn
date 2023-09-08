package com.example.filmein

import androidx.compose.ui.graphics.vector.ImageVector
import com.example.filmein.ui.EyeClosed
import com.example.filmein.ui.EyeOpen

data class Movie(val title: String, val watched: Boolean = false) {
    fun getWatchStatusDrawable(): ImageVector {
        return if (watched) EyeOpen else EyeClosed
    }

}