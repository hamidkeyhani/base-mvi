package com.fourplay.network.model.exceptions

import androidx.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class CommonException(
    @SerialName("level")
    val level: String?,
    @SerialName("code")
    val code: String?,
    @SerialName("message")
    val message: String?,
    @SerialName("validationErrors")
    val validationErrors: List<CommonValidationError>?,
    @SerialName("details")
    val details: List<String>?,
    @SerialName("vposErrorCode")
    val vposErrorCode: String?,
    @SerialName("vposErrorMessage")
    val vposErrorMessage: String?,
    @SerialName("retrievalReferenceNumber")
    val retrievalReferenceNumber: String?
)