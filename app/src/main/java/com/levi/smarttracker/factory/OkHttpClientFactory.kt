package com.levi.smarttracker.factory

import android.content.Context
import com.levi.smarttracker.util.PreferenceUtil
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

object OkHttpClientFactory {

    fun buildOkHttpClient(context : Context): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC))
                .addInterceptor { chain ->
                    var request = chain.request()
                    val url = request.url().newBuilder().build()
                    request = if (!PreferenceUtil.getStringPreference(context, "AUTH_TOKEN").equals("")) {
                        request.newBuilder().header("Authorization", "Bearer " + PreferenceUtil.getStringPreference(context,
                                "AUTH_TOKEN")).url(url).build()
                    } else {
                        request.newBuilder().url(url).build()
                    }
                    chain.proceed(request)
                }.build()
    }

}