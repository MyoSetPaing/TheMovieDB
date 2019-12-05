package com.myosetpaing.themoviedb

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class CustomOKHttpInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val originalHttpUrl = original.url()

        // Request customization: add request headers
        val url = originalHttpUrl.newBuilder()
            .addQueryParameter("api_key", "043af0eae90d85fe27b0343b382f2605")
            .build()
        val requestBuilder: Request.Builder = original.newBuilder()
            .url(url)
        val request = requestBuilder.build()
        return chain.proceed(request)
    }

}