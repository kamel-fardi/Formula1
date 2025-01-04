package com.kamelfardi.formula1.data

import com.google.gson.Gson
import com.google.gson.JsonElement
import com.google.gson.JsonObject

data class Comment(
    val userId: String? = null,
    val postId: String? = null,
    val commentId: String? = null,
    val comment: String? = null
) {
    companion object {
        private val gson = Gson()

        // Function to convert JSON string to Comment object
        fun fromJson(jsonString: String): Comment {
            return gson.fromJson(jsonString, Comment::class.java)
        }

        // Function to convert Comment object to JSON string
        fun toJson(comment: Comment): String {
            return gson.toJson(comment)
        }
    }
}

