package com.fourplay.datastore.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserDm(
    val accountId: String,
    val accountName: String,
    val birthDate: String,
    val country: String,
    val countryId: String,
    val createdDate: String,
    val email: String,
    val fullName: String,
    val gender: Int,
    val id: String,
    val imageUrl: String,
    val languages: List<String>,
    val nationality: String,
    val nationalityId: String,
    val phoneNumber: String,
    val title: String,
    val titleId: String,
) : Parcelable {
    companion object {
        val EMPTY =
            UserDm(
                accountId = "",
                accountName = "",
                birthDate = "",
                country = "",
                countryId = "",
                createdDate = "",
                email = "",
                fullName = "",
                gender = 0,
                id = "",
                imageUrl = "",
                languages = emptyList(),
                nationality = "",
                nationalityId = "",
                phoneNumber = "",
                title = "",
                titleId = "",
            )


    }
}


fun UserDm.toLocalModel() = UserLocalModel(
    accountId = this.accountId,
    accountName = this.accountName,
    birthDate = this.birthDate,
    country = this.country,
    countryId = this.countryId,
    createdDate = this.createdDate,
    email = this.email,
    fullname = this.fullName,
    gender = this.gender,
    id = this.id,
    imageUrl = this.imageUrl,
    languages = this.languages,
    nationality = this.nationality,
    nationalityId = this.nationalityId,
    phoneNumber = this.phoneNumber,
    title = this.title,
    titleId = this.titleId,
)

fun UserLocalModel.toDm() = UserDm(
    accountId = this.accountId.orEmpty(),
    accountName = this.accountName.orEmpty(),
    birthDate = this.birthDate.orEmpty(),
    country = this.country.orEmpty(),
    countryId = this.countryId.orEmpty(),
    createdDate = this.createdDate.orEmpty(),
    email = this.email.orEmpty(),
    fullName = this.fullname.orEmpty(),
    gender = this.gender ?: 0,
    id = this.id.orEmpty(),
    imageUrl = this.imageUrl.orEmpty(),
    languages = this.languages.orEmpty(),
    nationality = this.nationality.orEmpty(),
    nationalityId = this.nationalityId.orEmpty(),
    phoneNumber = this.phoneNumber.orEmpty(),
    title = this.title.orEmpty(),
    titleId = this.titleId.orEmpty(),
)
