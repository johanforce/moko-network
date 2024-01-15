package com.jarvis.kmm.dto

import dev.icerock.moko.resources.desc.StringDesc

data class AstroHomeDto(
    var tvDataMoonIllu: StringDesc? = null,
    var tvDataMoonPhase: StringDesc? = null,
    var tvDataVector: StringDesc? = null,
    var tvDataVisibility: StringDesc? = null,
    var tvDataCloudcover: StringDesc? = null,
)