package com.schooliraha.irahaschool.presentation.teachers

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

/**

 */

const val TEACHERS_SCREEN_ROUTE = "teachers"
fun NavGraphBuilder.teachersNavGraph(navController: NavController) {
    composable(route = TEACHERS_SCREEN_ROUTE) {
        TeachersScreen(navController)
    }
}