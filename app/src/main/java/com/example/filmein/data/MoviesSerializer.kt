package com.example.filmein.data

import androidx.datastore.core.CorruptionException
import androidx.datastore.core.Serializer
import com.example.filmein.MoviesProto
import com.google.protobuf.InvalidProtocolBufferException
import java.io.InputStream
import java.io.OutputStream

object MoviesSerializer : Serializer<MoviesProto> {

    override val defaultValue: MoviesProto = MoviesProto.getDefaultInstance()

    override suspend fun readFrom(input: InputStream): MoviesProto {
        try {
            return MoviesProto.parseFrom(input)
        } catch (exception: InvalidProtocolBufferException) {
            throw CorruptionException("Cannot read proto.", exception)
        }
    }

    override suspend fun writeTo(
        t: MoviesProto,
        output: OutputStream
    ) = t.writeTo(output)
}