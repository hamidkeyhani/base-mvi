package com.fourplay.network.interceptors

import RefreshApi
import com.fourplay.datastore.UserLocalDataStore
import com.fourplay.network.NetworkConstants.CUSTOM_HEADER
import com.fourplay.network.NetworkConstants.NO_AUTH
import com.fourplay.network.di.AuthNetwork
import com.fourplay.network.model.refreshToken.RefreshTokenRequestDto
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import retrofit2.Retrofit
import java.net.HttpURLConnection.HTTP_UNAUTHORIZED
import javax.inject.Inject


class AuthInterceptor @Inject constructor(
    private val dataStore: UserLocalDataStore,
    @AuthNetwork val retrofit: Retrofit
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val req = chain.request()

        if (NO_AUTH in req.headers(CUSTOM_HEADER)) {
            return chain.proceedWithToken(req, null)
        } else {
            val token = getToken()

            var res = chain.proceedWithToken(req, token)

            if (res.code != HTTP_UNAUTHORIZED || token.isEmpty()) {
                return res
            }
            res = callRefreshToken(token, res, chain)

            return res
        }
    }

    private fun callRefreshToken(
        token: String,
        response: Response,
        chain: Interceptor.Chain
    ): Response {
        var res = response
        val oldRefreshToken = dataStore.getRefreshToken()
        if (token.isNotEmpty() && oldRefreshToken.isNotEmpty()) {

            runBlocking {
                val responseNewTokenLoginModel = retrofit.create(RefreshApi::class.java)
                    .refreshToken(RefreshTokenRequestDto(dataStore.getJWTToken(), oldRefreshToken))

                return@runBlocking when {
                    responseNewTokenLoginModel.code() != 200 -> {
                        //todo redirect user to login
                        // AuthManager().authExpiredAndGoLogin(AndroidApplication().getContext())
                        res
                    }
                    else -> {
                        val originalRequest = chain.request()
                        responseNewTokenLoginModel.body()?.result?.apply {
                            accessToken?.let { token ->
                                dataStore.saveJWTToken(token)
                                dataStore.saveRefreshToken(refreshToken.orEmpty())

                                val newAuthenticationRequest =
                                    originalRequest.newBuilder()
                                        .addHeader("Authorization", "Bearer $token").build()
                                res = chain.proceed(newAuthenticationRequest)
                            }
                        }
                        return@runBlocking res
                    }
                }
            }
        }
        return res
    }

    private fun getToken(): String {
        return runBlocking {
            dataStore.getJWTToken()
        }
    }

    private fun Interceptor.Chain.proceedWithToken(req: Request, token: String?): Response =
        req.newBuilder().apply {
            if (token !== null) {
                addHeader("Authorization", "Bearer $token")
            }
        }.removeHeader(CUSTOM_HEADER).build().let(::proceed)
}
