package com.alisdn.samplemvvmandroid.di

import com.alisdn.samplemvvmandroid.Utils.API_KEY
import com.alisdn.samplemvvmandroid.Utils.BASE_URL
import com.alisdn.samplemvvmandroid.data.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BASIC)

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                OkHttpClient.Builder().addInterceptor
                { chain ->
                    val request = chain.request().newBuilder()
                        .addHeader("x-api-key", API_KEY)
                        .build()
                    chain.proceed(request)
                }
                    .addInterceptor(logging)
                    .build()
            )
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)

}