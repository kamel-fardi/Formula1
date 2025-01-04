package com.kamelfardi.formula1.data

import com.google.gson.Gson

data class ConstructorStanding(
    val position: String? = null,
    val positionText: String? = null,
    val points: String? = null,
    val wins: String? = null,
    val constructor: Constructor? = null
) {
    companion object {
        private val gson = Gson()

        // Function to convert JSON string to ConstructorStandings object
        fun fromJson(jsonString: String): ConstructorStanding {
            return gson.fromJson(jsonString, ConstructorStanding::class.java)
        }
    }

    // Function to convert ConstructorStandings object to JSON string
    fun toJson(): String {
        return gson.toJson(this)
    }
}
