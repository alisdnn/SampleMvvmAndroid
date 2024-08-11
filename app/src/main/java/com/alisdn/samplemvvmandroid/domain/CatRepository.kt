package com.alisdn.samplemvvmandroid.domain

import com.alisdn.samplemvvmandroid.data.network.ApiService
import javax.inject.Inject

class CatRepository
@Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getCats(limit: Int, page: Int): List<Cat> {
        return apiService.getCats(limit, page).map { it.toCat() }
    }
}
