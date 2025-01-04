package com.kamelfardi.formula1.services


import com.kamelfardi.formula1.data.User
import com.kamelfardi.formula1.services.base.ApiRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UserServices {
    final  val apiRepository = ApiRepository(endpoint = "User")

    //make it singleton
    companion object {
        private var instance: UserServices? = null
        fun getInstance(): UserServices {
            if (instance == null) {
                instance = UserServices()
            }
            return instance as UserServices
        }
    }
suspend fun getAllUsers(): List<User>? {
        val response = withContext(Dispatchers.IO) {
            apiRepository.getAll<List<User>>()
        }
        return if (response.isSuccessful) {
            response.body()
        } else {
            null
        }
    }
    suspend fun createUser(user: User): User? {
        val response = withContext(Dispatchers.IO) {
            apiRepository.create<User>(user)
        }
        return if (response.isSuccessful) {
            response.body()
        } else {
            null
        }
    }
    suspend fun getUserById(id: String): User? {
        val response = withContext(Dispatchers.IO) {
            apiRepository.getById<User>(id)
        }
        return if (response.isSuccessful) {
            response.body()
        } else {
            null
        }
    }
    suspend fun updateUser(user: User): User? {
        val response = withContext(Dispatchers.IO) {
            apiRepository.update<User>(user.id, user)
        }
        return if (response.isSuccessful) {
            response.body()
        } else {
            null
        }
    }
    suspend fun deleteUser(id: String): User? {
        val response = withContext(Dispatchers.IO) {
            apiRepository.delete<User>( id)
        }
        return if (response.isSuccessful) {
            response.body()
        } else {
            null
        }
    }
}