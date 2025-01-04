package com.kamelfardi.formula1.data

import com.google.gson.Gson

data class Standing(
    val season: String? = null,
    val round: String? = null,
    val constructorStandings: List<ConstructorStanding>? = null,
    val driverStandings: List<DriverStanding>? = null
) {
    companion object {
        private val gson = Gson()

        // Function to convert JSON string to Standing object
        fun fromJson(jsonString: String): Standing {
            return gson.fromJson(jsonString, Standing::class.java)
        }
    }

    // Function to convert Standing object to JSON string
    fun toJson(): String {
        return gson.toJson(this)
    }
}
