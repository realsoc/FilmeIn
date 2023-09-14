package com.example.filmein

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import com.example.filmein.data.MoviesSerializer

/**
 * if This is true execute block, otherwise return null
 *
 * Used in
 * val value = isResult()
 * value ifTrue { code executed if value == true } ?: { code executed if value == false }
 */
fun <T>Boolean.ifTrue(block: () -> T): T? {
    return if (this) {
        block.invoke()
    } else {
        null
    }
}

val Context.moviesDataStore: DataStore<MoviesProto> by dataStore(
    fileName = "movies.pb",
    serializer = MoviesSerializer
)