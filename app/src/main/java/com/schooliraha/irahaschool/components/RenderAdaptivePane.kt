package com.schooliraha.irahaschool.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun RenderAdaptivePane(
    contentAlignment: Alignment = Alignment.TopCenter,
    content: @Composable () -> Unit,
) {

    Box(
        Modifier
            .fillMaxSize(),
        contentAlignment = contentAlignment,
    ) {
        content()
    }
}

