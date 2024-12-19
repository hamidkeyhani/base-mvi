package com.base.common.errorHandling

sealed class ErrorType {

    sealed class Api : com.base.common.errorHandling.ErrorType() {

        object Network : com.base.common.errorHandling.ErrorType.Api()

        object ServiceUnavailable : com.base.common.errorHandling.ErrorType.Api()

        object NotFound : com.base.common.errorHandling.ErrorType.Api()

        object Server : com.base.common.errorHandling.ErrorType.Api()

        data class Other(val code: String = "", val message: String = "") : com.base.common.errorHandling.ErrorType.Api()

    }

    object Unknown : com.base.common.errorHandling.ErrorType()
}