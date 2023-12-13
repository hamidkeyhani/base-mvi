package com.fourplay.common.errorHandling

sealed class ErrorType {

    sealed class Api : com.fourplay.common.errorHandling.ErrorType() {

        object Network : com.fourplay.common.errorHandling.ErrorType.Api()

        object ServiceUnavailable : com.fourplay.common.errorHandling.ErrorType.Api()

        object NotFound : com.fourplay.common.errorHandling.ErrorType.Api()

        object Server : com.fourplay.common.errorHandling.ErrorType.Api()

        data class Other(val code: String = "", val message: String = "") : com.fourplay.common.errorHandling.ErrorType.Api()

    }

    object Unknown : com.fourplay.common.errorHandling.ErrorType()
}