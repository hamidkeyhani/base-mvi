package com.base.common.errorHandling.extensions

import java.io.IOException

fun Throwable.toErrorType() = when (this) {
    is IOException -> com.base.common.errorHandling.ErrorType.Api.Network
//    is HttpException -> when (code() {
//        ErrorCodes.Http.ResourceNotFound -> ErrorType.Api.NotFound
//        ErrorCodes.Http.InternalServer -> ErrorType.Api.Server
//        ErrorCodes.Http.ServiceUnavailable -> ErrorType.Api.ServiceUnavailable
//        else -> ErrorType.Unknown
//    }
    else -> com.base.common.errorHandling.ErrorType.Unknown
}