package com.alisdn.samplemvvmandroid.domain

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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

    private var _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> = _isLoading

    private var currentPage = 1
    private var pageSize = 10


    init {
        fetchCats()
    }

    fun fetchCats(page: Int = currentPage, size: Int = pageSize) {
        viewModelScope.launch {
            _isLoading.value = true
            val newCats = catRepository.getCats(size, page)
            _cats.value = newCats
            currentPage = page
            pageSize = size
            _isLoading.value = false
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
        fetchCats(1, newSize) // Start over from the first page with the new size
    }
}
