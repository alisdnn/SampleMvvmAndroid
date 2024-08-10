package com.alisdn.samplemvvmandroid.data

import com.alisdn.samplemvvmandroid.domain.Cat
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiService {
    @GET("images/search")
    suspend fun getCats(
        @Query("limit") limit: Int,
        @Query("page") page: Int,
        @Query("order") order: String = "Desc",
        @Header("x-api-key") apiKey: String = "24be637f-e596-4847-b47a-1791feeea1bd"
    ): List<CatResponse>
}