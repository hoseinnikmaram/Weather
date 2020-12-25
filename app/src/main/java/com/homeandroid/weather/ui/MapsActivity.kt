package com.homeandroid.weather.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.homeandroid.weather.R
import com.homeandroid.weather.databinding.ActivityMapsBinding


class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding
    var position = LatLng(35.6,51.0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_maps);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        binding.showWeather.setOnClickListener {

            val i = Intent(this, WeatherActivity::class.java)
            i.putExtra("lat",position.latitude)
            i.putExtra("lon",position.longitude)
            startActivity(i)
        }
    }


    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        mMap.uiSettings.setAllGesturesEnabled(true)
        mMap.uiSettings.isCompassEnabled = true
        mMap.uiSettings.setMapToolbarEnabled(true)
        mMap.uiSettings.setMyLocationButtonEnabled(true)
        mMap.uiSettings.setTiltGesturesEnabled(true)
        mMap.uiSettings.setZoomGesturesEnabled(true)
        mMap.uiSettings.setScrollGesturesEnabled(true)
        mMap.uiSettings.setZoomControlsEnabled(true)

      //  mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(position,10F))
        mMap.setOnCameraMoveListener {
            position = mMap.cameraPosition.target

        }

    }



}