package com.levi.smarttracker.api.module

import android.content.Context
import com.levi.smarttracker.api.service.DeviceApiService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.levi.smarttracker.builder.OkHttpClientBuilder.buildOkHttpClient

@Module
class DeviceApiModule(private val context: Context) {

    private val url = "http://192.168.100.108:8080"

    @Provides
    fun provideClient(): OkHttpClient {
        return buildOkHttpClient(context)
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
    fun provideApiService(): DeviceApiService {
        return provideRetrofit(url, provideClient()).create<DeviceApiService>(DeviceApiService::class.java)
    }

}