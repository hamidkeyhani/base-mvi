package com.fourplay.datastore

import android.content.SharedPreferences
import com.fourplay.datastore.UserLocalDataStore.DataStoreKeys.JWT_TOKEN_KEY
import com.fourplay.datastore.UserLocalDataStore.DataStoreKeys.REFRESH_TOKEN_KEY
import com.fourplay.datastore.UserLocalDataStore.DataStoreKeys.USER_DATA_KEY
import com.fourplay.datastore.model.UserDm
import com.fourplay.datastore.model.UserLocalModel
import com.fourplay.datastore.model.toDm
import com.fourplay.datastore.model.toLocalModel
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import javax.inject.Inject

class UserLocalDataStore @Inject constructor(
    private val sharedPreferences: SharedPreferences,
) {
    object DataStoreKeys {
        const val TENANT_ID_KEY = "TENANT_ID_KEY"
        const val DEVICE_ID_KEY = "DEVICE_ID_KEY"
        const val IS_ON_BOARDING_FIRST_TIME_KEY = "IS_ON_BOARDING_FIRST_TIME"
        const val JWT_TOKEN_KEY = "JWT_TOKEN_KEY"
        const val USER_DATA_KEY = "USER_DATA_KEY"
        const val REFRESH_TOKEN_KEY = "REFRESH_TOKEN_KEY"
    }

    fun saveJWTToken(token: String) {
        with(sharedPreferences.edit()) {
            putString(JWT_TOKEN_KEY, token)
            apply()
        }
    }

    fun saveUserData(user: UserDm) {
        with(sharedPreferences.edit()) {
            putString(USER_DATA_KEY, convertToString(user.toLocalModel()))
            apply()
        }
    }

    fun getUserData(): UserDm {
        return parseString<UserLocalModel>(sharedPreferences.getStringOrEmpty(USER_DATA_KEY)).toDm()
    }

    fun getJWTToken(): String {
        return sharedPreferences.getStringOrEmpty(JWT_TOKEN_KEY)
    }

    fun saveRefreshToken(token: String) {
        with(sharedPreferences.edit()) {
            putString(REFRESH_TOKEN_KEY, token)
            apply()
        }
    }

    fun getRefreshToken(): String {
        return sharedPreferences.getStringOrEmpty(REFRESH_TOKEN_KEY)
    }

    private fun SharedPreferences.getStringOrEmpty(key: String, default: String? = null): String {
        return this.getString(key, default) ?: default.orEmpty()
    }


    private inline fun <reified T> convertToString(inputModel: T): String {
        val json = Json { encodeDefaults = true }
        return json.encodeToString(value = inputModel)
    }

    private inline fun <reified T> parseString(input: String): T {
        val json = Json { encodeDefaults = true }
        return json.decodeFromString(input)
    }
}