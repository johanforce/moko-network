package com.jarvis.kmm.dto

import dev.icerock.moko.resources.desc.StringDesc

data class IndexHomeDto(
    var indexUV: String? = null,
    var tvDataUV: StringDesc? = null,
    var tvDataHum: StringDesc? = null,
    var tvDataWind: StringDesc? = null,
)