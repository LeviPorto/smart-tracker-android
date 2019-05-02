package com.levi.smarttracker.api.module

import android.content.Context
import com.levi.smarttracker.api.service.UserApiService
import com.levi.smarttracker.factory.OkHttpClientFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class UserApiModule(private val context: Context) {

    private val url = "http://192.168.100.108:8080"

    @Provides
    fun provideClient(): OkHttpClient {
        return OkHttpClientFactory.buildOkHttpClient(context)
    }

    @Provides
    fun provideRetrofit(baseURL: String, client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .baseUrl(baseURL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    @Provides
    fun provideApiService(): UserApiService {
        return provideRetrofit(url, provideClient()).create<UserApiService>(UserApiService::class.java)
    }

}