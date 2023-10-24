package com.schooliraha.irahaschool.bottomnav

import android.os.Build
import androidx.activity.result.ActivityResultRegistryOwner
import androidx.annotation.DrawableRes
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.schooliraha.irahaschool.presentation.home.HomeScreen
import com.schooliraha.irahaschool.R
import com.schooliraha.irahaschool.bottomnav.DestinationGraph.ACCOUNTS_SCREEN_ROUTE
import com.schooliraha.irahaschool.bottomnav.DestinationGraph.HOME_SCREEN_ROUTE
import com.schooliraha.irahaschool.bottomnav.DestinationGraph.LOANS_SCREEN_ROUTE
import com.schooliraha.irahaschool.bottomnav.DestinationGraph.MARKET_SCREEN_ROUTE
import com.schooliraha.irahaschool.bottomnav.DestinationGraph.ROOT_ROUTE
import com.schooliraha.irahaschool.bottomnav.DestinationGraph.TRANSACTION_SCREEN_ROUTE
import com.schooliraha.irahaschool.presentation.academics.academicsNavGraph
import com.schooliraha.irahaschool.presentation.attendance.attendanceNavGraph
import com.schooliraha.irahaschool.presentation.home.HOMES_SCREEN_ROUTE
import com.schooliraha.irahaschool.presentation.home.homeNavGraph
import com.schooliraha.irahaschool.presentation.notice_board.noticeBoardNavGraph
import com.schooliraha.irahaschool.presentation.staff.staffNavGraph
import com.schooliraha.irahaschool.presentation.students.studentsNavGraph
import com.schooliraha.irahaschool.presentation.teachers.teachersNavGraph


enum class BottomBarDestination(val route: String, @DrawableRes val icon: Int, val title: String) {
    HOME(HOMES_SCREEN_ROUTE, R.drawable.ic_choice, "HOME"),
    TRANSACTION(TRANSACTION_SCREEN_ROUTE, R.drawable.ic_calendar, "EXAM"),
    LOANS(LOANS_SCREEN_ROUTE, R.drawable.ic_bug_report, "TEACHER"),
    MARKET(MARKET_SCREEN_ROUTE, R.drawable.ic_choice, "LEARN"),
    ACCOUNTS(ACCOUNTS_SCREEN_ROUTE, R.drawable.ic_currency, "MORE")

}

@RequiresApi(Build.VERSION_CODES.P)
@Composable
fun RootNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        route = ROOT_ROUTE,
        startDestination = HOMES_SCREEN_ROUTE
    ) {
        homeNavGraph(navController)
        academicsNavGraph(navController)
        attendanceNavGraph(navController)
        noticeBoardNavGraph(navController)
        studentsNavGraph(navController)
        staffNavGraph(navController)
        teachersNavGraph(navController)
        transactionNavGraph(navController)
        loansNavGraph(navController)
        marketNavGraph(navController)
        accountNavGraph(navController)

    }

}


fun NavGraphBuilder.transactionNavGraph(navController: NavHostController) {
    composable(route = TRANSACTION_SCREEN_ROUTE){
        TransactionScreen()
    }
}
fun NavGraphBuilder.loansNavGraph(navController: NavHostController) {
    composable(route = LOANS_SCREEN_ROUTE){
        LoansScreen()
    }
}

fun NavGraphBuilder.marketNavGraph(navController: NavHostController) {
    composable(route = MARKET_SCREEN_ROUTE){
        MarketScreen()
    }
}
fun NavGraphBuilder.accountNavGraph(navController: NavHostController) {
    composable(route = ACCOUNTS_SCREEN_ROUTE){
        AccountScreen()
    }
}

@Composable
fun AccountScreen() {
    Column {
        Text(text = "Hello")
    }
}

@Composable
fun TransactionScreen() {
    Column {
        Text(text = "Hello")
    }
}

@Composable
fun LoansScreen() {
    Column {
        Text(text = "Hello")
    }
}

@Composable
fun MarketScreen() {
    Column {
        Text(text = "Hello")
    }
}



