package com.fourplay.datastore.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserLocalModel(
    @SerialName("accountId")
    val accountId: String? = null,
    @SerialName("accountName")
    val accountName: String? = null,
    @SerialName("birthDate")
    val birthDate: String? = null,
    @SerialName("country")
    val country: String? = null,
    @SerialName("countryId")
    val countryId: String? = null,
    @SerialName("createdDate")
    val createdDate: String? = null,
    @SerialName("email")
    val email: String? = null,
    @SerialName("fullName")
    val fullname: String? = null,
    @SerialName("gender")
    val gender: Int? = null,
    @SerialName("id")
    val id: String? = null,
    @SerialName("imageUrl")
    val imageUrl: String? = null,
    @SerialName("languages")
    val languages: List<String>? = null,
    @SerialName("nationality")
    val nationality: String? = null,
    @SerialName("nationalityId")
    val nationalityId: String? = null,
    @SerialName("phoneNumber")
    val phoneNumber: String? = null,
    @SerialName("title")
    val title: String? = null,
    @SerialName("titleId")
    val titleId: String? = null
)