package com.schooliraha.irahaschool.modal_sheet

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.safeGesturesPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalLayoutApi::class, ExperimentalMaterial3Api::class)
@Composable
fun IrahaModalSheet(
    modifier: Modifier = Modifier,
    modalSheetHeight: Modifier = Modifier.fillMaxHeight(0.85f),
    sheetState: SheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true),
    onDismissRequest: () -> Unit,
    content: @Composable ColumnScope.() -> Unit,
) {

     BoxWithConstraints {
         Surface {
             ModalBottomSheet(
                 sheetState = sheetState,
                 onDismissRequest = {
                     onDismissRequest()
                 },
                 modifier = modalSheetHeight,
                 dragHandle = null,
                 shape = RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp),
             ) {
                 Column(
                     modifier = Modifier
                         .safeGesturesPadding()
                 ) {
                     content()
                     Spacer(modifier = Modifier.weight(1f))
                 }
             }
         }

     }

}


