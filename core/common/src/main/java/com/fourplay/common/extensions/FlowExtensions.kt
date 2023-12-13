package com.fourplay.common.extensions

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


//if you have flowOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10) ->
//[1, 2, 3]
//[4, 5, 6]
//[7, 8, 9]
//[10]
fun <T> Flow<T>.chunked(chunkSize: Int): Flow<List<T>> {
    require(chunkSize > 0) { "Chunk size must be positive" }
    return flow {
        var chunk = mutableListOf<T>()
        collect { item ->
            chunk.add(item)
            if (chunk.size == chunkSize) {
                emit(chunk)
                chunk = mutableListOf()
            }
        }
        if (chunk.isNotEmpty()) {
            emit(chunk)
        }
    }
}