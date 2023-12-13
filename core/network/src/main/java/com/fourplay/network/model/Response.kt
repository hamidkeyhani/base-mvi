package com.fourplay.network.model

import com.fourplay.network.model.exceptions.ExceptionData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.transform

sealed class Response<out T> {

    data class Success<out T>(val data: T) : Response<T>()
    data class Failure(val exceptionData: ExceptionData) : Response<Nothing>()
    object Loading : Response<Nothing>()
    object NetworkError : Response<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success $data"
            is Failure -> "Failure $exceptionData"
            Loading -> "Loading"
            NetworkError -> "Network is disconnected"
        }
    }
}

fun <T, R> Response<T>.map(transform: (T) -> R): Response<R> {
    return when (this) {
        is Response.Success -> Response.Success(transform(data))
        is Response.Failure -> Response.Failure(exceptionData)
        Response.Loading -> Response.Loading
        Response.NetworkError -> Response.NetworkError
    }
}

fun <T> Flow<Response<T>>.doOnSuccess(action: suspend (T) -> Unit): Flow<Response<T>> =
    transform { result ->
        if (result is Response.Success) {
            action(result.data)
        }
        return@transform emit(result)
    }

fun <T> Flow<Response<T>>.doOnFailure(action: suspend (ExceptionData) -> Unit): Flow<Response<T>> =
    transform { result ->
        if (result is Response.Failure) {
            action(result.exceptionData)
        }
        return@transform emit(result)
    }

fun <T> Flow<Response<T>>.doOnLoading(action: suspend () -> Unit): Flow<Response<T>> =
    transform { result ->
        if (result is Response.Loading) {
            action()
        }
        return@transform emit(result)
    }


fun <T> Flow<Response<T>>.doOnNetworkError(action: suspend () -> Unit): Flow<Response<T>> =
    transform { result ->
        if (result is Response.NetworkError) {
            action()
        }
        return@transform emit(result)
    }

