package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityMainBinding
import dev.icerock.moko.mvvm.getViewModel
import dev.icerock.moko.mvvm.livedata.bindText
import ru.alex009.moko.network.myapplication.WeatherViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel: WeatherViewModel = getViewModel { WeatherViewModel() }

        binding.viewaaa.bindText(this, viewModel.weatherDataString)

        viewModel.getWeatherLocation("hanoi")
    }
}