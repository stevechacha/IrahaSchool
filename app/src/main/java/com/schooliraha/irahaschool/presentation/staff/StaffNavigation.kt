package com.schooliraha.irahaschool.presentation.staff

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

/**
 */

const val STAFF_SCREEN_ROUTE = "staff"
fun NavGraphBuilder.staffNavGraph(navController: NavController) {
    composable(route = STAFF_SCREEN_ROUTE) {
        StaffScreen(navController)
    }
}