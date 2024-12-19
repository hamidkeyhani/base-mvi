package com.base.network.interceptors

//import com.base.network.LanguageHelper
import com.base.network.NetworkConstants
//import com.base.storage.DataStore
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import javax.inject.Inject

class CustomHeadersInterceptor @Inject constructor(
//    private val dataStore: DataStore,
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val req = chain.request()
        return chain.proceedWithHeaders(req)
    }

    private fun Interceptor.Chain.proceedWithHeaders(req: Request): Response =
        req.newBuilder().apply {
            addHeader("accept", "application/json")
//            addHeader("accept-language", LanguageHelper.getLanguageOrDefault())
            addHeader("x-source-channel", "Mobile")
//            addHeader("x-tenant-id", dataStore.getTenantId())
//            addHeader("x-device-id", dataStore.getDeviceId())
        }.removeHeader(NetworkConstants.CUSTOM_HEADER).build().let(::proceed)
}
