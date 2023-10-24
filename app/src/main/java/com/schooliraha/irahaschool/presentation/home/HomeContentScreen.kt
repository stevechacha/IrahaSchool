package com.schooliraha.irahaschool.presentation.home

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.LocalOverscrollConfiguration
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.schooliraha.irahaschool.R
import com.schooliraha.irahaschool.components.AppViewModel
import com.schooliraha.irahaschool.modal_sheet.IrahaModalSheet
import com.schooliraha.irahaschool.modal_sheet.IrahaModalSheetLayout
import com.schooliraha.irahaschool.modal_sheet.TransactionBottomSheetType


@RequiresApi(Build.VERSION_CODES.N)
@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun HomeContentScreen(
    navController: NavController,
    appViewModel: AppViewModel = viewModel(),
) {
    var isSheetOpen by rememberSaveable { mutableStateOf(false) }
    var currentBottomSheet: TransactionBottomSheetType? by remember { mutableStateOf(null) }
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {},
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            CompositionLocalProvider(
                LocalOverscrollConfiguration provides null
            ) {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(3),
                    verticalArrangement = Arrangement.spacedBy(5.dp),
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    item(span = { GridItemSpan(3) }) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Start
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(60.dp)
                                    .border(
                                        color = Color.LightGray,
                                        width = 1.dp,
                                        shape = CircleShape
                                    ),
                                contentAlignment = Alignment.Center
                            ) {
                                IconButton(onClick = {

                                }) {
                                    Icon(
                                        imageVector = Icons.Default.Person,
                                        contentDescription = null,
                                        modifier = Modifier.size(30.dp)
                                    )
                                }
                            }

                            Column(
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(start = 12.dp),
                                verticalArrangement = Arrangement.Center,
                            ) {
                                Text(text = "Greetings")
                                Text(text = "Name")

                            }
                        }
                    }
                    item(span = { GridItemSpan(3) }) {
                        Spacer(modifier = Modifier.height(16.dp))
                    }

                    item {
                        HomeCardItem(
                            title = "STUDENTS",
                            icon = R.drawable.ic_choice,
                            onClick = {
                                isSheetOpen = true
                                currentBottomSheet = TransactionBottomSheetType.NOTICE_BOARD_SHEET
                            }
                        )
                    }
                    item {
                        HomeCardItem(
                            title = "TEACHERS",
                            icon = R.drawable.ic_choice,
                            onClick = {
                                isSheetOpen = true
                                currentBottomSheet = TransactionBottomSheetType.TEACHERS_SHEET
                            }
                        )
                    }
                    item {
                        HomeCardItem(
                            title = "STAFF",
                            icon = R.drawable.ic_choice,
                            onClick = {
                                isSheetOpen = true
                                currentBottomSheet = TransactionBottomSheetType.STAFF_SHEET

                            }
                        )

                    }

                    item {
                        HomeCardItem(
                            title = "EXAMS",
                            icon = R.drawable.ic_choice,
                            onClick = { }
                        )

                    }
                    item {
                        HomeCardItem(
                            title = "FINANCIAL",
                            icon = R.drawable.ic_choice,
                            onClick = {
                                isSheetOpen = true
                                currentBottomSheet = TransactionBottomSheetType.FINANCIAL_SHEET

                            }
                        )

                    }
                    item {
                        HomeCardItem(
                            title = "ACADEMICS",
                            icon = R.drawable.ic_choice,
                            onClick = { }
                        )

                    }
                    item {
                        HomeCardItem(
                            title = "ATTENDANCE",
                            icon = R.drawable.ic_choice,
                            onClick = { }
                        )

                    }
                    item {
                        HomeCardItem(
                            title = "NOTICE BOARD",
                            icon = R.drawable.ic_choice,
                            onClick = {
                                isSheetOpen = true
                                currentBottomSheet = TransactionBottomSheetType.NOTICE_BOARD_SHEET
                            }
                        )

                    }

                }
            }
        }

    }

    if (isSheetOpen) {
        IrahaModalSheet(
            onDismissRequest = {
                isSheetOpen = false
            },
        ) {
            currentBottomSheet?.let {
                IrahaModalSheetLayout(
                    bottomSheetType = it,
                    onClose = {}
                )
            }
        }
    }


}