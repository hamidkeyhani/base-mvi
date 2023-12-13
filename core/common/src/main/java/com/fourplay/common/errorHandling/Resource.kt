package com.fourplay.common.errorHandling

sealed class Resource<out T> {
    data class Success<T>(val data: T): com.fourplay.common.errorHandling.Resource<T>()
    data class Error<T>(val error: com.fourplay.common.errorHandling.ErrorType): com.fourplay.common.errorHandling.Resource<T>()
    object Loading: com.fourplay.common.errorHandling.Resource<Nothing>()

    override fun toString(): String {
        return when (this) {
            is com.fourplay.common.errorHandling.Resource.Success<*> -> "Success $data"
            com.fourplay.common.errorHandling.Resource.Loading -> "Loading"
            is com.fourplay.common.errorHandling.Resource.Error -> "Error $error"
        }
    }

}