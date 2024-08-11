package com.alisdn.samplemvvmandroid.data.network

import com.alisdn.samplemvvmandroid.data.CatResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiService {
    @GET("images/search")
    suspend fun getCats(
        @Query("limit") limit: Int,
        @Query("page") page: Int,
        @Query("order") order: String = "Desc"
    ): List<CatResponse>
}