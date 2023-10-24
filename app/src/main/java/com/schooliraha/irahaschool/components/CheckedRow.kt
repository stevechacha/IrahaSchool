package com.schooliraha.irahaschool.components

import androidx.compose.foundation.selection.toggleable
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import com.danilkinkin.buckwheat.base.TextRow
import com.schooliraha.irahaschool.R
import com.schooliraha.irahaschool.common.theme.IrahaSchoolTheme


@Composable
fun CheckedRow(
    modifier: Modifier = Modifier,
    checked: Boolean,
    onValueChange: (isChecked: Boolean) -> Unit,
    text: String,
    description: String? = null,
    endContent: @Composable (() -> Unit)? = null,
    endCaption: String? = null,
) {
    TextRow(
        modifier = modifier
            .toggleable(
                value = checked,
                onValueChange = { onValueChange(!checked) },
                role = Role.Checkbox
            ),
        icon = if (checked) painterResource(R.drawable.ic_launcher_background) else null,
        iconTint = MaterialTheme.colorScheme.primary,
        text = text,
        description = description,
        textStyle = MaterialTheme.typography.bodyMedium.copy(
            fontWeight = MaterialTheme.typography.bodyLarge.fontWeight,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
        ),
        endContent = endContent,
        endCaption = endCaption,
    )
}

@Preview
@Composable
fun PreviewCheckedRow() {
    val (checkedState, onStateChange) = remember { mutableStateOf(false) }

    IrahaSchoolTheme() {
        CheckedRow(
            checked = checkedState,
            onValueChange = { onStateChange(it) },
            text = "Option selection",
        )
    }
}

@Preview
@Composable
fun PreviewCheckedRowChekecd() {
    val (checkedState, onStateChange) = remember { mutableStateOf(true) }

    IrahaSchoolTheme {
        CheckedRow(
            checked = checkedState,
            onValueChange = { onStateChange(it) },
            text = "Option selection",
        )
    }
}