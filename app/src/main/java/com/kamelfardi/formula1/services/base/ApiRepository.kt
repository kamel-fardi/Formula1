package com.kamelfardi.formula1.services.base

import retrofit2.Response

class ApiRepository(private val endpoint: String) {

    // You can now set the endpoint dynamically when initializing ApiRepository
    suspend fun <T> getAll(): Response<T> {
        return RetrofitClient.apiService.getAll(endpoint)
    }

    suspend fun <T> getById(id: String): Response<T> {
        return RetrofitClient.apiService.getById(endpoint, id)
    }

    suspend fun <T> update(id: String, requestBody: Any): Response<T> {
        return RetrofitClient.apiService.update(endpoint, id, requestBody)
    }

    suspend fun <T> delete(id: String): Response<T> {
        return RetrofitClient.apiService.delete(endpoint, id)
    }

    suspend fun <T> create(requestBody: Any): Response<T> {
        return RetrofitClient.apiService.create(endpoint, requestBody)
    }
}
