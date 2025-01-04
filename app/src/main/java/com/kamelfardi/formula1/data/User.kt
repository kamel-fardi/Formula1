package com.kamelfardi.formula1.data

import com.google.gson.Gson

data class User(
    val id: String,
    val firstName: String? = null,
    val lastName: String? = null,
    val dateOfBirth: String? = null,
    val imageUrl: String? = null,
    val email: String? = null,
    val password: String? = null,
    val postsIds: List<String>? = null,
    val commentsIds: List<String>? = null,
    val likesIds: List<String>? = null
) {
    companion object {
        private val gson = Gson()

        // Function to convert JSON string to User object
        fun fromJson(jsonString: String): User {
            return gson.fromJson(jsonString, User::class.java)
        }
    }

    // Function to convert User object to JSON string
    fun toJson(): String {
        return gson.toJson(this)
    }
}

