package com.levi.smarttracker.api.module

/**
 * Created by levip on 28/03/2019.
 */
import android.content.Context
import com.levi.smarttracker.api.service.LoginApiService
import com.levi.smarttracker.builder.OkHttpClientBuilder.buildOkHttpClient
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class LoginApiModule(private val context: Context) {

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
    fun provideApiService(): LoginApiService {
        return provideRetrofit(url, provideClient()).create<LoginApiService>(LoginApiService::class.java)
    }

}