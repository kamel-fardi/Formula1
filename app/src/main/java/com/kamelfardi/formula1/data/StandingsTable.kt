package com.kamelfardi.formula1.data

import com.google.gson.Gson

data class StandingsTable(
    val season: String? = null,
    val standingsLists: List<Standing>? = null
) {
    companion object {
        private val gson = Gson()

        // Function to convert JSON string to StandingsTable object
        fun fromJson(jsonString: String): StandingsTable {
            return gson.fromJson(jsonString, StandingsTable::class.java)
        }
    }

    // Function to convert StandingsTable object to JSON string
    fun toJson(): String {
        return gson.toJson(this)
    }
}
