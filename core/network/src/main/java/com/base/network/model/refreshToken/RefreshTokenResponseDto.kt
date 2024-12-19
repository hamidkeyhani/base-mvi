package com.base.network.model.refreshToken


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RefreshTokenResponseDto(
    @SerialName("accessToken")
    val accessToken: String?,
    @SerialName("description")
    val description: String?,
    @SerialName("refreshToken")
    val refreshToken: String?,
    @SerialName("responseCode")
    val responseCode: String?
)