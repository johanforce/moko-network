@file:Suppress("MemberVisibilityCanBePrivate")

package com.jarvis.kmm.common

import com.jarvis.kmm.MR
import com.jarvis.kmm.common.enum.WeatherEnum
import com.jarvis.kmm.common.enum.WindEnum
import com.jarvis.kmm.resources.KmmStrings
import com.soywiz.klock.DateFormat
import com.soywiz.klock.DateTimeTz
import com.soywiz.klock.KlockLocale
import dev.icerock.moko.resources.desc.StringDesc
import getStrings

object DataUtils {
    const val ISO_8601_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm"

    fun getDateUpdateTimeFormat(date: DateTimeTz, pattern: String = ISO_8601_DATE_TIME_FORMAT): String {
        return date.format(DateFormat(pattern).withLocale(KlockLocale.default))
    }

    fun convertIndexUV(data: String): StringDesc? {
        return try {
            when (data.toDouble()) {
                in 0.0..2.0 -> getStrings(MR.strings.uv_index_low)
                in 2.0..5.0 -> getStrings(MR.strings.uv_index_medium)
                in 5.0..11.0 -> getStrings(MR.strings.uv_index_high)
                else -> getStrings(MR.strings.uv_index_dangerous)
            }
        } catch (e: Exception) {
            null
        }
    }

    fun convertWindDirToWind(windDir: String): StringDesc? {
        return WindEnum.values().find { it.wind == windDir }?.data
    }

    fun convertTitleWeather(code: Int): StringDesc? {
        return WeatherEnum.values().find { it.code == code }?.nameWeather
    }

    private fun getLocale(): StringDesc.LocaleType {
        return StringDesc.LocaleType.System
    }
}
