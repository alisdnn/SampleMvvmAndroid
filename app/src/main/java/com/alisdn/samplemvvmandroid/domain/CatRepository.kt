package com.alisdn.samplemvvmandroid.domain

import com.alisdn.samplemvvmandroid.data.ApiService
import com.alisdn.samplemvvmandroid.data.CatResponse
import com.alisdn.samplemvvmandroid.data.toCat
import javax.inject.Inject

class CatRepository
@Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getCats(limit: Int, page: Int): List<Cat> {
        return apiService.getCats(limit, page).map { it.toCat() }
    }
}
