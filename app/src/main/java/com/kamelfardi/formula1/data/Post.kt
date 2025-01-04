package com.kamelfardi.formula1.data

import com.google.gson.Gson

data class Post(
    val userId: String? = null,
    val postId: String? = null,
    val title: String? = null,
    val image: String? = null
) {
    companion object {
        private val gson = Gson()

        // Function to convert JSON string to Post object
        fun fromJson(jsonString: String): Post {
            return gson.fromJson(jsonString, Post::class.java)
        }
    }

    // Function to convert Post object to JSON string
    fun toJson(): String {
        return gson.toJson(this)
    }
}

