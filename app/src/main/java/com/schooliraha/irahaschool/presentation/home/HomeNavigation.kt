package com.schooliraha.irahaschool.presentation.home

import android.os.Build
import androidx.activity.result.ActivityResultRegistryOwner
import androidx.annotation.RequiresApi
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable

/**
 */
const val HOMES_SCREEN_ROUTE = "home"

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@RequiresApi(Build.VERSION_CODES.P)
fun NavGraphBuilder.homeNavGraph(
    navController: NavController
) {
    composable(route = HOMES_SCREEN_ROUTE) {
        HomeContentScreen(
            navController = navController,
           )
    }
}
