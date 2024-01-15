package com.jarvis.kmm.dto

data class HomeDto(
    var bannerHomeDto: BannerHomeDto? = null,
    var astroHomeDto: AstroHomeDto? = null,
    var indexHomeDto: IndexHomeDto? = null,
    var sunHomeDto: SunHomeDto? = null,
    var listDataWeatherHourly: List<WeatherHourDto> ?= null
)