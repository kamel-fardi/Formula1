package com.kamelfardi.formula1.data

data class User(
    val firstName: String,
    val lastName: String,
    val dateOfBirth: String,
    val imageUrl: String,
    val email: String,
    val password: String,
    val postsIds : List<String>,
    val commentsIds : List<String>,
    val likesIds : List<String>

)
