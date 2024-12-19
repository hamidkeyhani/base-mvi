package com.base.network

import com.base.network.model.Response
import com.base.network.model.exceptions.ExceptionData
import com.base.network.model.exceptions.ExceptionResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import retrofit2.HttpException
import timber.log.Timber
import java.io.IOException

object ResponseHandler {

    suspend fun <T, D> safeApiCall(
        dispatcher: CoroutineDispatcher = Dispatchers.IO,
        mapToDomain: suspend (T) -> D,
        apiCall: suspend () -> retrofit2.Response<T>,
    ): Flow<Response<D>> = flow {
        emit(Response.Loading)
        Timber.i("Caaaaal, befor api call")
        val response = apiCall()
        Timber.i("Caaaaal, after apicall")
        if (response.isSuccessful) {
            val data = response.body()
            if (data != null) {
                emit(Response.Success(mapToDomain(data)))
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
                                message = exceptionData.message,
                                code = exceptionData.statusCode,
//                                validationErrorMessages = exceptionData.error
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
            is IOException -> emit(Response.Failure(ExceptionData(e.message)))
            is HttpException,
            -> {
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
}
