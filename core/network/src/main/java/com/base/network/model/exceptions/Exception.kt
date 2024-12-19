package com.base.network.model.exceptions


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Exception(
    @SerialName("code")
    val code: String? = null,
    @SerialName("details")
    val details: String? = null,
    @SerialName("level")
    val level: String? = null,
    @SerialName("message")
    val message: String? = null,
    @SerialName("retrievalReferenceNumber")
    val retrievalReferenceNumber: Int? = null,
    @SerialName("validationErrors")
    val validationErrors: List<CommonValidationError>? = null
)