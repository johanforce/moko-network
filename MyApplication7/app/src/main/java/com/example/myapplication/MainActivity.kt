package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding
import com.jarvis.kmm.viewmodel.WeatherViewModel
import dev.icerock.moko.mvvm.getViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel: WeatherViewModel = getViewModel { WeatherViewModel() }

        viewModel.getWeatherLocation(location = "hanoi",
            onSuccess = { binding.viewaaa.text = it.toString() }, onFail = {}
        )
    }
}