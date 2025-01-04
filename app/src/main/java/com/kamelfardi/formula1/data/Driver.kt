package com.kamelfardi.formula1.data

import com.google.gson.Gson

data class Driver(
    val driverId: String? = null,
    val permanentNumber: String? = null,
    val code: String? = null,
    val url: String? = null,
    val givenName: String? = null,
    val familyName: String? = null,
    val dateOfBirth: String? = null,
    val nationality: String? = null,
    val constructorName: String? = null,
    val backgroundColor: Long? = null
) {
    companion object {
        private val gson = Gson()

        // Function to convert JSON string to Driver object
        fun fromJson(jsonString: String): Driver {
            return gson.fromJson(jsonString, Driver::class.java)
        }
    }

    // Function to convert Driver object to JSON string
    fun toJson(): String {
        return gson.toJson(this)
    }
}
