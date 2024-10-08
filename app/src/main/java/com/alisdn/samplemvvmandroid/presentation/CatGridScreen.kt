package com.alisdn.samplemvvmandroid.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Divider
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter
import com.alisdn.samplemvvmandroid.domain.Cat
import com.alisdn.samplemvvmandroid.domain.CatViewModel

@Composable
fun CatGridScreen(
    viewModel: CatViewModel = hiltViewModel(),
    onClick: (Cat) -> Unit
) {
    val cats by viewModel.cats.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    var currentPage by rememberSaveable { mutableStateOf(0) }
    var pageSize by rememberSaveable { mutableStateOf(50) }

    Scaffold(
        bottomBar = {
            // Pagination controls in a fixed position at the bottom of the screen
            Column {
                Divider()
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Button(onClick = {
                        viewModel.previousPage()
                        currentPage = currentPage - 1
                    }, enabled = currentPage > 0) {
                        Text("Previous")
                    }

                    Button(onClick = {
                        viewModel.nextPage()
                        currentPage = currentPage + 1
                    }) {
                        Text("Next")
                    }
                }

                // Page size selector
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 50.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Page Size: ")
                    listOf(10, 20, 50, 100).forEach { size ->
                        Button(modifier = Modifier.padding(end = 2.dp),
                            onClick = {
                                viewModel.changePageSize(size)
                                pageSize = size
                                currentPage = 0 // Reset to the first page when page size changes
                            }) {
                            Text("$size")
                        }
                    }
                }
            }
        }
    ) { paddingValues ->
        // The LazyVerticalGrid displaying the list of cats
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.padding(paddingValues)
        ) {
            items(cats) { cat ->
                Image(
                    painter = rememberImagePainter(cat.url),
                    contentDescription = null,
                    modifier = Modifier
                        .clickable {
                            onClick(cat)
                        }
                        .padding(4.dp)
                        .fillMaxWidth()
                        .aspectRatio(1f)
                )
            }
        }

        if (isLoading) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                CircularProgressIndicator()
            }
        }
    }
}
