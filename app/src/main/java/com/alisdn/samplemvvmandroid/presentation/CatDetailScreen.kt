package com.alisdn.samplemvvmandroid.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter
import com.alisdn.samplemvvmandroid.domain.CatViewModel

@Composable
fun CatDetailScreen(
    viewModel: CatViewModel = hiltViewModel(),
    catId: String?
) {
    val cats by viewModel.cats.collectAsState()
    val cat = cats?.find { it.id == catId }
    if (cat != null) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .verticalScroll(rememberScrollState())
        ) {
            Image(
                painter = rememberImagePainter(cat.url),
                contentDescription = null,
                modifier = Modifier
                    .padding(32.dp)
                    .fillMaxWidth()
                    .aspectRatio(1f)
            )
            Text(text = "Cat ID: ${cat.id}")
            Text(text = "Dimensions: ${cat.width}x${cat.height}")
        }
    } else {
        Text(text = "Cat not found")
    }
}
