

package com.base.datastore.di

import android.content.Context
import android.content.SharedPreferences
import com.base.datastore.UserLocalDataStore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {
    private const val SHARED_PREFERENCES_NAME = "mvi-plus-app_shared_preferences"

    @Singleton
    @Provides
    fun provideSharedPref(context: Context): SharedPreferences = context.getSharedPreferences(
        SHARED_PREFERENCES_NAME,
        Context.MODE_PRIVATE
    )

    @Singleton
    @Provides
    fun provideUserDataStore(sharedPreferences: SharedPreferences): UserLocalDataStore =
        UserLocalDataStore(sharedPreferences)
}
