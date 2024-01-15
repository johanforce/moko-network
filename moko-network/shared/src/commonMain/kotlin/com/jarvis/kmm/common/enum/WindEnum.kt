package com.jarvis.kmm.common.enum

import com.jarvis.kmm.MR
import dev.icerock.moko.resources.desc.StringDesc
import getStrings

enum class WindEnum(val index: Int, val wind: String, val data: StringDesc) {
    N(0, "N", getStrings(MR.strings.north)),
    NNE(1, "NNE", getStrings(MR.strings.north_north_east)),
    NE(2, "NE", getStrings(MR.strings.north_east)),
    ENE(3, "ENE", getStrings(MR.strings.east_north_east)),
    E(4, "E", getStrings(MR.strings.east)),
    ESE(5, "ESE", getStrings(MR.strings.east_south_east)),
    SE(6, "SE", getStrings(MR.strings.south_east)),
    SSE(7, "SSE", getStrings(MR.strings.south_south_east)),
    S(8, "S", getStrings(MR.strings.south)),
    SSW(9, "SSW", getStrings(MR.strings.south_south_west)),
    SW(10, "SW", getStrings(MR.strings.south_west)),
    WSW(11, "WSW", getStrings(MR.strings.west_south_west)),
    W(12, "W", getStrings(MR.strings.west)),
    WNW(13, "WNW", getStrings(MR.strings.west_north_west)),
    NW(14, "NW", getStrings(MR.strings.north_west)),
    NNW(15, "NNW", getStrings(MR.strings.north_north_west))
}
