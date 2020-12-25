package com.homeandroid.weather.network

import com.homeandroid.weather.model.WeatherModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("forecast?appid=d093efe3d225b4d59e62e47e0f022657&units=metric")
   suspend fun getWeather(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double
    ): WeatherModel



}