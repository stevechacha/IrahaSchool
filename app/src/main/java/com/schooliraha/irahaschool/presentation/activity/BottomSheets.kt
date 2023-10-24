package com.schooliraha.irahaschool.presentation.activity

import android.os.Build
import androidx.activity.result.ActivityResultRegistryOwner
import androidx.annotation.RequiresApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.*
import androidx.hilt.navigation.compose.hiltViewModel
import com.schooliraha.irahaschool.components.AppViewModel
import com.schooliraha.irahaschool.components.BottomSheetWrapper
import com.schooliraha.irahaschool.presentation.academics.ACADEMICS_SCREEN_ROUTE
import com.schooliraha.irahaschool.presentation.academics.AcademicsScreen
import com.schooliraha.irahaschool.presentation.settings.LangSwitcherDialog
import com.schooliraha.irahaschool.presentation.settings.SETTINGS_CHANGE_LOCALE_SHEET
import com.schooliraha.irahaschool.presentation.settings.SETTINGS_CHANGE_THEME_SHEET
import com.schooliraha.irahaschool.presentation.settings.SETTINGS_SHEET
import com.schooliraha.irahaschool.presentation.settings.Settings
import com.schooliraha.irahaschool.presentation.settings.ThemeSwitcherDialog
import kotlinx.coroutines.launch
import java.util.*

@RequiresApi(Build.VERSION_CODES.N)
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomSheets(
    appViewModel: AppViewModel = hiltViewModel(),
) {

    val coroutineScope = rememberCoroutineScope()


    /*   BottomSheetWrapper(
           name = FINISH_DATE_SELECTOR_SHEET,
           windowSizeClass = windowSizeClass,
       ) { state ->
           FinishDateSelector(
               selectDate = state.args["initialDate"] as Date?,
               onBackPressed = {
                   coroutineScope.launch {
                       state.hide()
                   }
               },
               onApply = {
                   coroutineScope.launch {
                       state.hide(mapOf("finishDate" to it))
                   }
               },
           )
       }*/

    BottomSheetWrapper(
        name = SETTINGS_SHEET,
    ) { state ->
        Settings(
            onClose = {
                coroutineScope.launch { state.hide() }
            }
        )
    }

    BottomSheetWrapper(
        name = ACADEMICS_SCREEN_ROUTE,
    ) { state ->
        AcademicsScreen(
            onClose = {
                coroutineScope.launch { state.hide() }
            }
        )
    }


    /* BottomSheetWrapper(
         name = FINISH_PERIOD_SHEET,
         windowSizeClass = windowSizeClass,
         cancelable = false,
     ) { state ->
         FinishPeriod(
             activityResultRegistryOwner = activityResultRegistryOwner,
             onCreateNewPeriod = {
                 appViewModel.openSheet(PathState(WALLET_SHEET))
             },
             onClose = {
                 coroutineScope.launch { state.hide() }
             },
         )
     }*/


    BottomSheetWrapper(
        name = SETTINGS_CHANGE_THEME_SHEET,
    ) { state ->
        ThemeSwitcherDialog(
            onClose = {
                coroutineScope.launch { state.hide() }
            }
        )
    }

    BottomSheetWrapper(
        name = SETTINGS_CHANGE_LOCALE_SHEET,
    ) { state ->
        LangSwitcherDialog(
            onClose = {
                coroutineScope.launch { state.hide() }
            }
        )
    }

}