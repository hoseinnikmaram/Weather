package com.homeandroid.weather.ui

import android.os.Bundle
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.observe
import com.google.android.gms.maps.model.LatLng
import com.homeandroid.weather.R
import com.homeandroid.weather.databinding.ActivityWheatherBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class WeatherActivity : AppCompatActivity() {

    private val viewModel:WeatherViewModel by viewModel()
    lateinit var binding:ActivityWheatherBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_wheather);


       val lat=intent.getDoubleExtra("lat",35.6)
        val lon=intent.getDoubleExtra("lon",51.0)



        viewModel.getWeatherData(lat,lon)
        binding.data = viewModel
        binding.lifecycleOwner = this

        viewModel.errorMessage.observe(this){

            Toast.makeText(this,it,LENGTH_LONG).show()
        }

    }



}


