package com.alisdn.samplemvvmandroid.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alisdn.samplemvvmandroid.data.ApiService
import com.alisdn.samplemvvmandroid.data.CatResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CatViewModel
@Inject constructor(
    private val catRepository: CatRepository
) : ViewModel() {

    private val _cats = MutableStateFlow<List<Cat>>(emptyList())
    val cats: StateFlow<List<Cat>> = _cats

    private var currentPage = 0
    private var pageSize = 50

    init {
        fetchCats()
    }

    fun fetchCats(page: Int = currentPage, size: Int = pageSize) {
        viewModelScope.launch {
            val newCats = catRepository.getCats(size, page)
            _cats.value = newCats
            currentPage = page
            pageSize = size
        }
    }

    fun nextPage() {
        fetchCats(currentPage + 1, pageSize)
    }

    fun previousPage() {
        if (currentPage > 0) {
            fetchCats(currentPage - 1, pageSize)
        }
    }

    fun changePageSize(newSize: Int) {
        fetchCats(0, newSize) // Start over from the first page with the new size
    }
}
