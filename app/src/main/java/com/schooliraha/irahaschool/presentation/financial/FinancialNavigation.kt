package com.schooliraha.irahaschool.presentation.financial

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

/**
 */

const val FINANCIAL_SCREEN_ROUTE = "financial"
fun NavGraphBuilder.financialNavGraph(navController: NavController) {
    composable(route = FINANCIAL_SCREEN_ROUTE) {
        FinancialScreen(navController)
    }
}