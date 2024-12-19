package com.base.common.errorHandling

sealed class Resource<out T> {
    data class Success<T>(val data: T): com.base.common.errorHandling.Resource<T>()
    data class Error<T>(val error: com.base.common.errorHandling.ErrorType): com.base.common.errorHandling.Resource<T>()
    object Loading: com.base.common.errorHandling.Resource<Nothing>()

    override fun toString(): String {
        return when (this) {
            is com.base.common.errorHandling.Resource.Success<*> -> "Success $data"
            com.base.common.errorHandling.Resource.Loading -> "Loading"
            is com.base.common.errorHandling.Resource.Error -> "Error $error"
        }
    }

}