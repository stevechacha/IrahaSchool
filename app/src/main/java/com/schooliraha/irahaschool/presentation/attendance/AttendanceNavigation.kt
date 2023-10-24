package com.schooliraha.irahaschool.presentation.attendance

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

/**
 */

const val ATTEDANCE_SCREEN_ROUTE = "attendance"
fun NavGraphBuilder.attendanceNavGraph(navController: NavController) {
    composable(route = ATTEDANCE_SCREEN_ROUTE) {
        AttendanceScreen(navController)
    }
}