package com.jarvis.kmm

import dev.icerock.moko.mvvm.livedata.LiveData
import dev.icerock.moko.mvvm.livedata.MutableLiveData
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import dev.icerock.moko.network.generated.apis.WeatherApi
import dev.icerock.moko.network.generated.models.Weather
import io.ktor.client.HttpClient
import io.ktor.client.features.logging.Logging
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json

class WeatherViewModel : ViewModel() {
    private val _weatherData: MutableLiveData<Weather> = MutableLiveData(Weather())
    private val weatherData: LiveData<Weather> get() = _weatherData

    private val _data = MutableLiveData("")
    val data: MutableLiveData<String> get() = _data

    private val httpClient: HttpClient = HttpClient {
        install(Logging)
    }

    private val weatherApi: WeatherApi = WeatherApi(
        httpClient = httpClient,
        json = Json {
            ignoreUnknownKeys = true
        }
    )

    fun getWeatherLocation(location: String) {
        viewModelScope.launch {
            val joke: Result<Weather> = runCatching { weatherApi.locationGet(location = location, format = "j1") }
            joke.onSuccess {
                    // _weatherData.value = it
                    _data.value = it.toString()
                }
                .onSuccess { println("joke: $it") }
                .onFailure { println("error: $it") }
        }
    }
}
