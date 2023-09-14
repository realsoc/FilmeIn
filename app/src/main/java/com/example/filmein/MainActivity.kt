package com.example.filmein

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.filmein.data.MovieRepositoryImpl
import com.example.filmein.data.MoviesLocalDataSourceImpl
import com.example.filmein.ui.FilmeScreen
import com.example.filmein.ui.FilmeScreenViewModel

class MainActivity : ComponentActivity() {
    // TODO : How to handle colors
    // TODO : Splash screen
    // TODO : Error message in dialog
    // TODO : Fetch information from api
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            FilmeScreen(FilmeScreenViewModel(MovieRepositoryImpl(MoviesLocalDataSourceImpl(this.moviesDataStore))))
        }
    }
}