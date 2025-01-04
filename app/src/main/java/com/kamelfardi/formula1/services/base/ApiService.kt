package com.kamelfardi.formula1.services.base
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {
    // Generic GET request, returns any type of response
    @GET("{endpoint}")
    suspend fun <T> getAll(
        @Path("endpoint") endpoint: String
    ): Response<T>

    @GET("{endpoint}/{id}")
    suspend fun <T> getById(
        @Path("endpoint") endpoint: String,
        @Path("id") id: String
    ): Response<T>

    // Generic POST request, takes request body and returns any type of response
    @POST("{endpoint}")
    suspend fun <T> create(
        @Path("endpoint") endpoint: String,
        @Body requestBody: Any
    ): Response<T>

    @POST("{endpoint}/{id}")
    suspend fun <T> update(
        @Path("endpoint") endpoint: String,
        @Path("id") id: String,
        @Body requestBody: Any
    ): Response<T>

    @DELETE("{endpoint}/{id}")
    suspend fun <T> delete(
        @Path("endpoint") endpoint: String,
        @Path("id") id: String
    ): Response<T>
}