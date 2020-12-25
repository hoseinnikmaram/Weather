package com.homeandroid.weather.util

import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("setcelsius")
fun TextView.setcelsius(fahrenheit:Double){

    text = (((fahrenheit - 32)*5)/9).toString()
}