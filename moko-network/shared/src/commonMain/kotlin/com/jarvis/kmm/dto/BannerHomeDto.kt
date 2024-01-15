package com.jarvis.kmm.dto

import dev.icerock.moko.resources.desc.StringDesc

data class BannerHomeDto(
    var latitude: Double? = null,
    var longitude: Double? = null,
    var tvTemp: StringDesc? = null,
    var ivTempCurrentCode: Int? = null,
    var tvTitle: StringDesc? = null,
    var tvFeel: StringDesc? = null,
    var tvMinMaxTempCurrent: String? = null,
    var tvTimeCurrent: String? = null,
)