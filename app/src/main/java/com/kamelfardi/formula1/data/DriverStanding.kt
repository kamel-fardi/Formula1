package com.kamelfardi.formula1.data

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

data class DriverStanding(
    val position: String? = null,
    val positionText: String? = null,
    val points: String? = null,
    val wins: String? = null,
    val driver: Driver? = null,
    val constructors: List<Constructor>? = null
) {
    companion object {
        // Convert JSON to DriverStanding object (fromJson)
        fun fromJson(json: String): DriverStanding {
            val type = object : TypeToken<DriverStanding>() {}.type
            return Gson().fromJson(json, type)
        }

        // Convert DriverStanding object to JSON (toJson)
        fun toJson(driverStanding: DriverStanding): String {
            return Gson().toJson(driverStanding)
        }
    }
}
