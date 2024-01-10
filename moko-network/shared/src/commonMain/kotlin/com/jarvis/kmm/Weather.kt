package com.jarvis.kmm

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AreaName(
    var value: String? = null
)

@Serializable
data class Astronomy(
    var moon_illumination: String? = null,
    var moon_phase: String? = null,
    var moonrise: String? = null,
    var moonset: String? = null,
    var sunrise: String? = null,
    var sunset: String? = null
)

@Serializable
data class Country(
    var value: String? = null
)

@Serializable
data class CurrentCondition(
    @SerialName("FeelsLikeC")
    var feelsLikeC: String? = null,
    @SerialName("FeelsLikeF")
    var feelsLikeF: String? = null,
    var cloudcover: String? = null,
    var humidity: String? = null,
    var lang_vi: List<LangVi>? = null,
    var localObsDateTime: String? = null,
    var observation_time: String? = null,
    var precipInches: String? = null,
    var precipMM: String? = null,
    var pressure: String? = null,
    var pressureInches: String? = null,
    var temp_C: String? = null,
    var temp_F: String? = null,
    var uvIndex: String? = null,
    var visibility: String? = null,
    var visibilityMiles: String? = null,
    var weatherCode: String? = null,
    var weatherDesc: List<WeatherDesc>? = null,
    var weatherIconUrl: List<WeatherIconUrl>? = null,
    var winddir16Point: String? = null,
    var winddirDegree: String? = null,
    var windspeedKmph: String? = null,
    var windspeedMiles: String? = null
)

@Serializable
data class Hourly(
    @SerialName("DewPointC")
    var dewPointC: String? = null,
    @SerialName("DewPointF")
    var dewPointF: String? = null,
    @SerialName("FeelsLikeC")
    var feelsLikeC: String? = null,
    @SerialName("FeelsLikeF")
    var feelsLikeF: String? = null,
    @SerialName("HeatIndexC")
    var heatIndexC: String? = null,
    @SerialName("HeatIndexF")
    var heatIndexF: String? = null,
    @SerialName("WindChillC")
    var windChillC: String? = null,
    @SerialName("WindChillF")
    var windChillF: String? = null,
    @SerialName("WindGustKmph")
    var windGustKmph: String? = null,
    @SerialName("WindGustMiles")
    var windGustMiles: String? = null,
    var chanceoffog: String? = null,
    var chanceoffrost: String? = null,
    var chanceofhightemp: String? = null,
    var chanceofovercast: String? = null,
    var chanceofrain: String? = null,
    var chanceofremdry: String? = null,
    var chanceofsnow: String? = null,
    var chanceofsunshine: String? = null,
    var chanceofthunder: String? = null,
    var chanceofwindy: String? = null,
    var cloudcover: String? = null,
    var humidity: String? = null,
    var lang_vi: List<LangVi>? = null,
    var precipInches: String? = null,
    var precipMM: String? = null,
    var pressure: String? = null,
    var pressureInches: String? = null,
    var tempC: String? = null,
    var tempF: String? = null,
    var time: String? = null,
    var uvIndex: String? = null,
    var visibility: String? = null,
    var visibilityMiles: String? = null,
    var weatherCode: String? = null,
    var weatherDesc: List<WeatherDesc>? = null,
    var weatherIconUrl: List<WeatherIconUrl>? = null,
    var winddir16Point: String? = null,
    var winddirDegree: String? = null,
    var windspeedKmph: String? = null,
    var windspeedMiles: String? = null
)

@Serializable
data class LangVi(
    var value: String? = null
)

@Serializable
data class NearestArea(
    var areaName: List<AreaName>? = null,
    var country: List<Country>? = null,
    var latitude: String? = null,
    var longitude: String? = null,
    var population: String? = null,
    var region: List<Region>? = null,
    var weatherUrl: List<WeatherUrl>? = null
)

@Serializable
data class Region(
    var value: String? = null
)

@Serializable
data class Request(
    var query: String? = null,
    var type: String? = null
)

@Serializable
data class WeatherData(
    var current_condition: List<CurrentCondition>? = null,
    var nearest_area: List<NearestArea>? = null,
    var request: List<Request>? = null,
    var weather: List<Weather>? = null
)

@Serializable
data class Weather(
    var astronomy: List<Astronomy>? = null,
    var avgtempC: String? = null,
    var avgtempF: String? = null,
    var date: String? = null,
    var hourly: List<Hourly>? = null,
    var maxtempC: String? = null,
    var maxtempF: String? = null,
    var mintempC: String? = null,
    var mintempF: String? = null,
    var sunHour: String? = null,
    var totalSnow_cm: String? = null,
    var uvIndex: String? = null
)

@Serializable
data class WeatherDesc(
    var value: String? = null
)

@Serializable
data class WeatherIconUrl(
    var value: String? = null
)

@Serializable
data class WeatherUrl(
    var value: String? = null
)