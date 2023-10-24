package com.schooliraha.irahaschool.presentation.academics

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

/**
 */
const val ACADEMICS_SCREEN_ROUTE = "academic"
fun NavGraphBuilder.academicsNavGraph(navController: NavController) {
    composable(route = ACADEMICS_SCREEN_ROUTE) {
        AcademicsScreen(onClose = {})
    }
}