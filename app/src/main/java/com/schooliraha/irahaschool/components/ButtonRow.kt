package com.schooliraha.irahaschool.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.danilkinkin.buckwheat.base.TextRow
import com.schooliraha.irahaschool.R
import com.schooliraha.irahaschool.common.theme.IrahaSchoolTheme

@Composable
fun ButtonRow(
    modifier: Modifier = Modifier,
    icon: Painter? = null,
    iconInset: Boolean = true,
    endIcon: Painter? = null,
    text: String,
    wrapMainText: Boolean = false,
    description: String? = null,
    denseDescriptionOffset: Boolean = true,
    onClick: () -> Unit,
    endContent: @Composable (() -> Unit)? = null,
    endCaption: String? = null,
) {
    val interactionSource = remember { MutableInteractionSource() }

    TextRow(
        modifier
            .clickable(
                interactionSource = interactionSource,
                indication = rememberRipple()
            ) { onClick.invoke() },
        icon = icon,
        iconInset = iconInset,
        endIcon = endIcon,
        wrapMainText = wrapMainText,
        text = text,
        description = description,
        denseDescriptionOffset = denseDescriptionOffset,
        endContent = endContent,
        endCaption = endCaption,
    )
}

@Preview
@Composable
fun PreviewButtonRowWithIcon() {
    IrahaSchoolTheme {
        ButtonRow(
            icon = painterResource(R.drawable.ic_launcher_background),
            text = "Text row",
            onClick = {},
        )
    }
}

@Preview
@Composable
fun PreviewButtonRowWithoutIcon() {
    IrahaSchoolTheme {
        ButtonRow(
            text = "Text row",
            onClick = {},
        )
    }
}