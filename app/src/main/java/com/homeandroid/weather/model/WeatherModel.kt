package com.homeandroid.weather.model


import com.google.gson.annotations.SerializedName

data class WeatherModel(
    @SerializedName("city")
    val city: City?,
    @SerializedName("cnt")
    val cnt: Int?,
    @SerializedName("cod")
    val cod: String?,
    @SerializedName("list")
    val list: List<ListModel>?,
    @SerializedName("message")
    val message: Int?
)