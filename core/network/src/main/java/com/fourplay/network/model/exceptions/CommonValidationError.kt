package com.fourplay.network.model.exceptions

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CommonValidationError(
    @SerialName("field")
    val field: String?,
    @SerialName("message")
    val message: String?,
    @SerialName("code")
    val code: String?
)