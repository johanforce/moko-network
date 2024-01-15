package com.jarvis.android

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jarvis.android.databinding.ActivityMainBinding
import com.jarvis.kmm.MR
import com.jarvis.kmm.viewmodel.WeatherViewModel
import dev.icerock.moko.mvvm.getViewModel
import dev.icerock.moko.resources.StringResource
import dev.icerock.moko.resources.desc.Resource
import dev.icerock.moko.resources.desc.StringDesc
import dev.icerock.moko.resources.desc.desc
import dev.icerock.moko.resources.format
import getStrings

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel: WeatherViewModel = getViewModel { WeatherViewModel() }
        binding.jokeText.text = getStrings(MR.strings.percent_index, "45").toString(this)
        binding.randomBtn.setOnClickListener {
            viewModel.getWeatherLocation(
                location = "hanoi",
                onSuccess = {
                    binding.jokeText.text = it.toString()
                },
                onFail = {
                    binding.jokeText.text = it.toString()
                }
            )
        }
    }
}
class Strings(private val context: Context) {
    fun get(id: StringResource, vararg args: Any): String {
        return if (args.isEmpty()) {
            StringDesc.Resource(id).toString(context = context)
        } else {
            id.format(*args).toString(context)
        }
    }
}
