package com.levi.smarttracker.api.module

import android.content.Context
import com.levi.smarttracker.api.service.DeviceApiService
import com.levi.smarttracker.util.PreferenceUtil.getStringPreference
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class DeviceApiModule(private val context: Context) {

    private val url = "http://192.168.100.7:8080"

    @Provides
    fun provideClient(): OkHttpClient {

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BASIC

        return OkHttpClient.Builder().addInterceptor(interceptor).addInterceptor { chain ->
            var request = chain.request()
            val url = request.url().newBuilder().build()
            request = if(!getStringPreference(context,"AUTH_TOKEN").equals("")){
                request.newBuilder().header("Authorization", "Bearer " + getStringPreference(context,
                        "AUTH_TOKEN")).url(url).build()
            } else{
                request.newBuilder().url(url).build()
            }
            chain.proceed(request)
        }.build()
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