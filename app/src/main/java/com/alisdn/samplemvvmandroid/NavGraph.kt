package com.alisdn.samplemvvmandroid

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.alisdn.samplemvvmandroid.domain.CatViewModel
import com.alisdn.samplemvvmandroid.presentation.CatDetailScreen
import com.alisdn.samplemvvmandroid.presentation.CatGridScreen

@Composable
fun NavGraph(startDestination: String = "cat_grid") {
    val navController = rememberNavController()
    val sharedViewModel: CatViewModel = hiltViewModel()

    NavHost(navController = navController, startDestination = startDestination) {
        composable("cat_grid") {
            CatGridScreen(viewModel = sharedViewModel) { selectedCat ->
                navController.navigate("cat_details/${selectedCat.id}")
            }
        }
        composable("cat_details/{catId}") { backStackEntry ->
            val catId = backStackEntry.arguments?.getString("catId")
            CatDetailScreen(catId = catId, viewModel = sharedViewModel)
        }
    }
}
