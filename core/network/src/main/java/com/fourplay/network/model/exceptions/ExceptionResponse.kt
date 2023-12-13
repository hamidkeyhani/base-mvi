package com.fourplay.network.model.exceptions


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ExceptionResponse(
    @SerialName("correlationId")
    val correlationId: Int? = null,
    @SerialName("exception")
    val exception: Exception? = null,
    @SerialName("message")
    val message: String? = null,
    @SerialName("requestId")
    val requestId: Int? = null,
    @SerialName("result")
    val result: String? = null,
    @SerialName("statusCode")
    val statusCode: Int? = null
)