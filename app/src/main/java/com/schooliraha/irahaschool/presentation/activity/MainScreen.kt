package com.schooliraha.irahaschool.presentation.activity

import android.os.Build
import androidx.activity.result.ActivityResultRegistryOwner
import androidx.annotation.RequiresApi
import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.rememberSwipeableState
import androidx.compose.material3.*
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.coerceAtLeast
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.schooliraha.irahaschool.bottomnav.BottomNavigationBar
import com.schooliraha.irahaschool.bottomnav.RootNavGraph
import com.schooliraha.irahaschool.common.theme.isNightMode
import com.schooliraha.irahaschool.components.AppViewModel
import com.schooliraha.irahaschool.components.SwipeableSnackbarHost
import com.schooliraha.irahaschool.components.SystemBarState
import com.schooliraha.irahaschool.components.TopSheetValue
import com.schooliraha.irahaschool.presentation.home.HomeScreen
import com.schooliraha.irahaschool.util.setSystemStyle
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

@RequiresApi(Build.VERSION_CODES.P)
@OptIn(ExperimentalMaterialApi::class, FlowPreview::class)
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigationBar(navController = navController) },
        modifier = Modifier.fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            RootNavGraph(
                navController = navController,
            )
        }

    }
}


@Composable
fun BoxScope.SnackbarHost(
    appViewModel: AppViewModel = viewModel(),
) {
    val snackbarHostState = remember { appViewModel.snackbarHostState }

    Column(
        horizontalAlignment = Alignment.End,
        modifier = Modifier
            .align(Alignment.BottomCenter)
            .fillMaxWidth()
            .navigationBarsPadding(),
    ) {
        SwipeableSnackbarHost(hostState = snackbarHostState)
    }
}

@Composable
fun StatusBarStub() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .requiredHeight(
                WindowInsets.systemBars
                    .asPaddingValues()
                    .calculateTopPadding()
            )
            .background(MaterialTheme.colorScheme.background)
    )
}
