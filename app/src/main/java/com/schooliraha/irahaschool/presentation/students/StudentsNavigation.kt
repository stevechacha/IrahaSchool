package com.schooliraha.irahaschool.presentation.students

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

/**
 */

const val STUDENTS_SCREEN_ROUTE = "students"
fun NavGraphBuilder.studentsNavGraph(navController: NavController) {
    composable(route = STUDENTS_SCREEN_ROUTE) {
        StudentsScreen(navController)
    }
}