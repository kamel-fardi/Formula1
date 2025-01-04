package com.kamelfardi.formula1.data

import com.google.gson.Gson

data class Like(
    val userId: String? = null,
    val postId: String? = null
) {
    companion object {
        private val gson = Gson()

        // Function to convert JSON string to Like object
        fun fromJson(jsonString: String): Like {
            return gson.fromJson(jsonString, Like::class.java)
        }
    }

    // Function to convert Like object to JSON string
    fun toJson(): String {
        return gson.toJson(this)
    }
}
