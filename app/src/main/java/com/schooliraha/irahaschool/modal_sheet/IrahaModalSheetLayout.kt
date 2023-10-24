package com.schooliraha.irahaschool.modal_sheet

import androidx.compose.animation.AnimatedContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.compose.animation.ExperimentalAnimationApi
import com.schooliraha.irahaschool.presentation.attendance.AttendanceScreen
import com.schooliraha.irahaschool.presentation.financial.FinancialScreen
import com.schooliraha.irahaschool.presentation.notice_board.NoticeBoardScreen
import com.schooliraha.irahaschool.presentation.staff.StaffScreen
import com.schooliraha.irahaschool.presentation.teachers.TeachersScreen


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun IrahaModalSheetLayout(
    bottomSheetType: TransactionBottomSheetType,
    onClose: () -> Unit,
    navController: NavController = rememberNavController()
) {

    AnimatedContent(
        label = "",
        targetState =  bottomSheetType,
    ) {bottomSheetTypes->
        when (bottomSheetTypes) {
            TransactionBottomSheetType.TEACHERS_SHEET -> TeachersScreen(navController = navController)
            TransactionBottomSheetType.STAFF_SHEET -> StaffScreen(navController = navController)
            TransactionBottomSheetType.FINANCIAL_SHEET -> FinancialScreen(navController = navController)
            TransactionBottomSheetType.ATTENDANCE_SHEET -> AttendanceScreen(navController = navController)
            TransactionBottomSheetType.NOTICE_BOARD_SHEET -> NoticeBoardScreen(navController = navController)
        }
    }
}

enum class TransactionBottomSheetType{
    TEACHERS_SHEET,
    STAFF_SHEET,
    FINANCIAL_SHEET,
    ATTENDANCE_SHEET,
    NOTICE_BOARD_SHEET,
}