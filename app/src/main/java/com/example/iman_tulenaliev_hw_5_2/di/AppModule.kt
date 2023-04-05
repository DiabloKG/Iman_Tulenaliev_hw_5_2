package com.example.iman_tulenaliev_hw_5_2.di

import com.example.iman_tulenaliev_hw_5_2.remote.LoveApi
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    fun provideApi() : LoveApi{
        return Retrofit.Builder().baseUrl("https://love-calculator.p.rapidapi.com/").addConverterFactory(
            GsonConverterFactory.create()
        ).build().create(LoveApi::class.java)
    }
}