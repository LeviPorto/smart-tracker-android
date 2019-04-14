package com.levi.smarttracker.api.module

/**
 * Created by levip on 28/03/2019.
 */
import com.levi.smarttracker.api.service.LoginApiService
import com.levi.smarttracker.api.service.TrackerApiService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class TrackerApiModule {

    private val url = "http://192.168.100.7:8080"

    @Provides
    fun provideClient(): OkHttpClient {

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BASIC

        return OkHttpClient.Builder().addInterceptor(interceptor).addInterceptor { chain ->
            var request = chain.request()
            val url = request.url().newBuilder().build()
            request = request.newBuilder().url(url).build()
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
    fun provideApiService(): TrackerApiService {
        return provideRetrofit(url, provideClient()).create<TrackerApiService>(TrackerApiService::class.java)
    }

}