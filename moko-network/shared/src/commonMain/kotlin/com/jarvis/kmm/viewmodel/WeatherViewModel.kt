package com.jarvis.kmm.viewmodel

import com.jarvis.kmm.MR
import com.jarvis.kmm.common.DataUtils
import com.jarvis.kmm.dto.AstroHomeDto
import com.jarvis.kmm.dto.BannerHomeDto
import com.jarvis.kmm.dto.HomeDto
import com.jarvis.kmm.dto.IndexHomeDto
import com.jarvis.kmm.dto.SunHomeDto
import com.jarvis.kmm.dto.WeatherHourDto
import com.jarvis.kmm.resources.KmmStrings
import com.soywiz.klock.DateTimeTz
import dev.icerock.moko.mvvm.livedata.LiveData
import dev.icerock.moko.mvvm.livedata.MutableLiveData
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import dev.icerock.moko.network.generated.apis.WeatherApi
import dev.icerock.moko.network.generated.models.Weather
import getStrings
import io.ktor.client.HttpClient
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.features.logging.LogLevel
import io.ktor.client.features.logging.Logging
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json

class WeatherViewModel : ViewModel() {
    private val weatherApi: WeatherApi = WeatherApi(
        httpClient = NetworkClient.client,
        json = Json {
            ignoreUnknownKeys = true
        }
    )

    private fun getHomeDto(dataModel: Weather): HomeDto {
        return HomeDto(
            bannerHomeDto = updateViewBanner(dataModel),
            astroHomeDto = updateViewAstro(dataModel),
            listDataWeatherHourly = updateViewGraphWeather(dataModel),
            indexHomeDto = updateViewIndex(dataModel),
            sunHomeDto = updateViewSun(dataModel),
        )
    }

    private fun updateViewBanner(dataModel: Weather): BannerHomeDto {
        val statusWeather = DataUtils.convertTitleWeather(
            dataModel.currentCondition?.get(0)?.weatherCode?.toInt() ?: 0
        )
        val feelLike = dataModel.currentCondition?.get(0)?.feelsLikeC

        val tempCurrent =
            getStrings(MR.strings.current_temp, dataModel.currentCondition?.get(0)?.tempC ?: KmmStrings.EMPTY)
        val imageWeather = dataModel.currentCondition?.get(0)?.weatherCode?.toInt() ?: 0

        return BannerHomeDto(
            latitude = dataModel.nearestArea?.get(0)?.latitude?.toDouble() ?: 0.0,
            longitude = dataModel.nearestArea?.get(0)?.longitude?.toDouble() ?: 0.0,
            tvTemp = tempCurrent,
            ivTempCurrentCode = imageWeather,
            tvTitle = statusWeather,
            tvFeel = getStrings(MR.strings.feel_like, feelLike ?: KmmStrings.EMPTY),
            tvMinMaxTempCurrent =
            "Max: ${dataModel.weather?.get(0)?.maxtempC ?: KmmStrings.EMPTY}°/Min: ${dataModel.weather?.get(0)?.mintempC ?: KmmStrings.EMPTY}°",
            tvTimeCurrent = DataUtils.getDateUpdateTimeFormat(DateTimeTz.nowLocal())
        )
    }

    private fun updateViewAstro(dataModel: Weather): AstroHomeDto {
        val visibility = dataModel.currentCondition?.get(0)?.visibility
        val cloudcover = dataModel.currentCondition?.get(0)?.cloudcover
        val moonIllu = dataModel.weather?.get(0)?.astronomy?.get(0)?.moonIllumination
        val moonPhase = dataModel.weather?.get(0)?.astronomy?.get(0)?.moonPhase
        val windDir = DataUtils.convertWindDirToWind(
            dataModel.currentCondition?.get(0)?.winddir16Point ?: ""
        )

        return AstroHomeDto(
            tvDataMoonIllu = getStrings(MR.strings.percent_index, moonIllu ?: KmmStrings.EMPTY),
            tvDataMoonPhase = getStrings(MR.strings.percent_index, moonPhase ?: KmmStrings.EMPTY),
            tvDataVector = windDir,
            tvDataVisibility = getStrings(MR.strings.percent_index, visibility ?: KmmStrings.EMPTY),
            tvDataCloudcover = getStrings(MR.strings.percent_index, cloudcover ?: KmmStrings.EMPTY),
        )
    }

    private fun updateViewGraphWeather(dataModel: Weather): List<WeatherHourDto>? {
        val listData = mutableListOf<WeatherHourDto>()

        dataModel.weather?.flatMap {
            it.hourly?.map { hourlyModel ->
                listData.add(
                    WeatherHourDto(
                        hourlyModel.time, hourlyModel.tempC, hourlyModel.weatherCode
                    )
                )
            } ?: mutableListOf()
        }
        return listData
    }

    private fun updateViewIndex(dataModel: Weather): IndexHomeDto {
        val indexUV = dataModel.currentCondition?.get(0)?.uvIndex ?: KmmStrings.EMPTY
        val dataHumidity = dataModel.currentCondition?.get(0)?.humidity
        val speedWind = dataModel.currentCondition?.get(0)?.windspeedKmph

        return IndexHomeDto(
            indexUV = indexUV,
            tvDataUV = DataUtils.convertIndexUV(indexUV),
            tvDataHum = getStrings(MR.strings.percent_index, dataHumidity ?: KmmStrings.EMPTY),
            tvDataWind = getStrings(MR.strings.percent_index, speedWind ?: KmmStrings.EMPTY),
        )
    }

    private fun updateViewSun(dataModel: Weather): SunHomeDto {
        val sunRise = dataModel.weather?.get(0)?.astronomy?.get(0)?.sunrise
        val sunSet = dataModel.weather?.get(0)?.astronomy?.get(0)?.sunset

        return SunHomeDto(
            tvTimeSunRise = sunRise,
            tvTimeSunSet = sunSet,
        )
    }

    fun getWeatherLocation(
        location: String,
        onSuccess: ((data: HomeDto?) -> Unit),
        onFail: ((String?) -> Unit)?,
    ) {
        viewModelScope.launch {
            val weather: Result<Weather> = runCatching { weatherApi.locationGet(location = location, format = "j1") }
            weather.onSuccess { onSuccess.invoke(getHomeDto(it)) }
                .onFailure { onFail?.invoke(it.message) }
        }
    }
}
