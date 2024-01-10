package com.jarvis.android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jarvis.android.databinding.ActivityMainBinding
import com.jarvis.kmm.WeatherViewModel
import dev.icerock.moko.mvvm.getViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel: WeatherViewModel = getViewModel { WeatherViewModel() }

        viewModel.data.addObserver {
            binding.jokeText.text = it
        }

        binding.randomBtn.setOnClickListener { viewModel.getWeatherLocation("hanoi") }
    }
}
