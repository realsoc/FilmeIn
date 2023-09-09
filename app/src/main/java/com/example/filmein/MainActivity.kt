package com.example.filmein

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.filmein.ui.FilmeScreen

class MainActivity : ComponentActivity() {
    // TODO : How to handle colors
    // TODO : Splash screen
    // TODO : Error message in dialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            FilmeScreen(FilmeScreenViewModel())
        }
    }
}