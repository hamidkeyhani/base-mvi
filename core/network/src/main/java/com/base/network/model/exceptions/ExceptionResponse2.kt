package com.base.network.model.exceptions


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ExceptionResponse2(
    @SerialName("error")
    val error: String? = null,
    @SerialName("message")
    val message: String? = null,
    @SerialName("status")
    val status: String? = null,
    @SerialName("timestamp")
    val timestamp: Long? = null
)