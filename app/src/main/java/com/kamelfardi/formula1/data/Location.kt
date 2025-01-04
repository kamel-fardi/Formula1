package com.kamelfardi.formula1.data

import com.google.gson.Gson

data class Location(
    val lat: String? = null,
    val long: String? = null,
    val locality: String? = null,
    val country: String? = null
) {
    companion object {
        private val gson = Gson()

        // Function to convert JSON string to Location object
        fun fromJson(jsonString: String): Location {
            return gson.fromJson(jsonString, Location::class.java)
        }
    }

    // Function to convert Location object to JSON string
    fun toJson(): String {
        return gson.toJson(this)
    }
}
