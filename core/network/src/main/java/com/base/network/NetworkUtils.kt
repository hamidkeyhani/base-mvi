package com.base.network

import com.base.network.model.CommonResponse
import com.base.network.model.Mapper
import com.base.network.model.exceptions.ExceptionData
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.HttpException
import timber.log.Timber
import java.io.IOException
import com.base.network.model.exceptions.ExceptionResponse
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import com.base.network.model.Response
import retrofit2.Response as RR


suspend fun <T, D> safeApiCallWithMapping(
    dispatcher: CoroutineDispatcher = Dispatchers.IO,
    mapper: Mapper<T, D>,
    apiCall: suspend () -> RR<CommonResponse<T>>
): Flow<Response<D>> = flow {
    emit(Response.Loading)
    val response = apiCall()
    if (response.isSuccessful) {
        val data = response.body()?.result
        if (data != null) {
            emit(Response.Success(mapper.mapFrom(data)))
        } else {
            val error = response.errorBody()
            if (error != null) {
                emit(Response.Failure(ExceptionData(error.toString())))
            } else {
                emit(Response.Failure(ExceptionData("Something went wrong, Try again!")))
            }
        }
    } else {
        val exceptionString = response.errorBody()?.string()
        if (!exceptionString.isNullOrBlank()) {
            val exceptionData = Json.decodeFromString<ExceptionResponse>(exceptionString)
            try {
                emit(
                    Response.Failure(
                        ExceptionData(
                            message = exceptionData.exception?.message,
                            code = exceptionData.statusCode,
                            validationErrorMessages = exceptionData.exception?.validationErrors
                        )
                    )
                )
            } catch (e: Exception) {
                Timber.e(e)
                if (e is HttpException) {
                    val errorResult = e.errorBody
                    emit(Response.Failure(ExceptionData(errorResult)))
                }
            }
        } else {
            emit(Response.Failure(ExceptionData(response.message())))
        }
    }
}.catch { e ->
    Timber.e(e)
    when (e) {
        is IOException -> emit(Response.NetworkError)
        is HttpException -> {
            val errorResult = e.errorBody
            emit(Response.Failure(ExceptionData(errorResult)))
        }
    }
    emit(Response.Failure(ExceptionData(message = e.message)))
}.flowOn(dispatcher)

val HttpException.errorBody: String?
    get() = try {
        this.response()?.errorBody()?.string()
    } catch (exception: Exception) {
        null
    }
