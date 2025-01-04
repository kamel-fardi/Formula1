package com.kamelfardi.formula1.ui.screens.auth

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.kamelfardi.formula1.data.User

class AuthViewModel : ViewModel() {
    val firstName = mutableStateOf("")
    val lastName = mutableStateOf("")
    val dateOfBirth = mutableStateOf("")
    val imageUrl = mutableStateOf("")
    val email = mutableStateOf("")
    val password = mutableStateOf("")
    val errorMessage = mutableStateOf("")

    fun registerUser(): User? {
        if (firstName.value.isEmpty() || lastName.value.isEmpty() || dateOfBirth.value.isEmpty() ||
            imageUrl.value.isEmpty() || email.value.isEmpty() || password.value.isEmpty()
        ) {
            errorMessage.value = "Please fill out all fields."
            return null
        }
        errorMessage.value = ""
        return User(
            firstName = firstName.value,
            lastName = lastName.value,
            dateOfBirth = dateOfBirth.value,
            imageUrl = imageUrl.value,
            email = email.value,
            password = password.value,
            postsIds = emptyList(),
            commentsIds = emptyList(),
            likesIds = emptyList()
        )
    }
}
