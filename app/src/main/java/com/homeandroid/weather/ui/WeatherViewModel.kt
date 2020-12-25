package com.homeandroid.weather.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.homeandroid.weather.model.WeatherModel
import com.homeandroid.weather.network.ApiRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WeatherViewModel(val apiRepository:ApiRepository):ViewModel(){


    private val _weathermodel = MutableLiveData<WeatherModel>()
    val weathermodel: LiveData<WeatherModel>
        get() = _weathermodel


    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String>
        get() = _errorMessage

    fun getWeatherData(lat:Double,lan:Double) {

        viewModelScope.launch(Dispatchers.IO) {
            try {
                _weathermodel.postValue(apiRepository.getWeather(lat ,lan))
            } catch (e: Exception) {
                _errorMessage.postValue(e.message)
                Log.e("e",e.toString())
            }
        }

    }

}