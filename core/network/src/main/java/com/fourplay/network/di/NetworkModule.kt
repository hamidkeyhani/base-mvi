package com.fourplay.network.di

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.fourplay.network.BuildConfig
import com.fourplay.network.getUnsafeOkHttpClient
import com.fourplay.network.interceptors.AuthInterceptor
import com.fourplay.network.interceptors.CustomHeadersInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Qualifier
import javax.inject.Singleton


private const val HTTP_READ_TIMEOUT_IN_SECONDS = 60
private const val HTTP_CALL_TIMEOUT_IN_SECONDS = 60

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    private val stageBaseUrl = "https://nevitadev.solidict.com/"
    private val baseUrl =  stageBaseUrl

    @Singleton
    @Provides
    fun provideChucker(@ApplicationContext context: Context) =
        ChuckerInterceptor.Builder(context)
            .alwaysReadResponseBody(true)
            .build()

    @Singleton
    @Provides
    fun provideOkHttpLogger() =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)


    @Singleton
    @Provides
    fun provideOkHttpClient(
        authInterceptor: AuthInterceptor,
        chuckerInterceptor: ChuckerInterceptor,
        httpLoggingInterceptor: HttpLoggingInterceptor,
        customHeadersInterceptor: CustomHeadersInterceptor,
    ): OkHttpClient {
        val okHttpClient: OkHttpClient.Builder = getUnsafeOkHttpClient() ?: OkHttpClient.Builder()
        return okHttpClient
            .addInterceptor(authInterceptor)
            .addInterceptor(customHeadersInterceptor)
            .apply {
                if (BuildConfig.DEBUG) {
                    addNetworkInterceptor(httpLoggingInterceptor)
                    addNetworkInterceptor(chuckerInterceptor)
                }
            }
            .readTimeout(HTTP_READ_TIMEOUT_IN_SECONDS.toLong(), TimeUnit.SECONDS)
            .callTimeout(HTTP_CALL_TIMEOUT_IN_SECONDS.toLong(), TimeUnit.SECONDS)
            .build()
    }

    @AuthNetwork
    @Singleton
    @Provides
    fun provideAuthOkHttpClient(
        chuckerInterceptor: ChuckerInterceptor,
        httpLoggingInterceptor: HttpLoggingInterceptor,
        customHeadersInterceptor: CustomHeadersInterceptor,
    ): OkHttpClient {
        val okHttpClient: OkHttpClient.Builder = getUnsafeOkHttpClient() ?: OkHttpClient.Builder()
        return okHttpClient
            .addInterceptor(customHeadersInterceptor)
            .apply {
                if (BuildConfig.DEBUG) {
                    addNetworkInterceptor(httpLoggingInterceptor)
                    addNetworkInterceptor(chuckerInterceptor)
                }
            }
            .readTimeout(HTTP_READ_TIMEOUT_IN_SECONDS.toLong(), TimeUnit.SECONDS)
            .callTimeout(HTTP_CALL_TIMEOUT_IN_SECONDS.toLong(), TimeUnit.SECONDS)
            .build()
    }


    @OptIn(ExperimentalSerializationApi::class)
    @Singleton
    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
    ): Retrofit {
        val contentType = "application/json".toMediaType()
        val json = Json { ignoreUnknownKeys = true }
        val converterFactory = json.asConverterFactory(contentType)
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(converterFactory)
            .build()
    }

    @OptIn(ExperimentalSerializationApi::class)
    @AuthNetwork
    @Singleton
    @Provides
    fun provideAuthRetrofit(
        @AuthNetwork okHttpClient: OkHttpClient,
    ): Retrofit {
        val contentType = "application/json".toMediaType()
        val json = Json { ignoreUnknownKeys = true }
        val converterFactory = json.asConverterFactory(contentType)
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(converterFactory)
            .build()
    }
}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class AuthNetwork

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class MainNetwork