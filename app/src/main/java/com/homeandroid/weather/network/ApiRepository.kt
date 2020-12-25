package com.homeandroid.weather.network

import com.homeandroid.weather.model.WeatherModel


class ApiRepository(val apiService: ApiService) {

    suspend fun getWeather(lat:Double,lon:Double): WeatherModel {
        return apiService.getWeather(lat, lon)
    }


}