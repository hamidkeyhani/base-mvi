package com.fourplay.network.model

import com.fourplay.network.model.exceptions.CommonException
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CommonResponse<T>(
    @SerialName("result") val result: T?,
    @SerialName("exception") val exception: CommonException?
)