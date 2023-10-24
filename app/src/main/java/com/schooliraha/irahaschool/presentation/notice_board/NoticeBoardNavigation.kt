package com.schooliraha.irahaschool.presentation.notice_board

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

/**
 */
const val NOTICE_BOARD_SCREEN_ROUTE = "notice_board"
fun NavGraphBuilder.noticeBoardNavGraph(navController: NavController) {
    composable(route = NOTICE_BOARD_SCREEN_ROUTE) {
        NoticeBoardScreen(navController)
    }
}