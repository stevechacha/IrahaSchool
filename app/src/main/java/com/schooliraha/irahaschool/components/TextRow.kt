package com.danilkinkin.buckwheat.base

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.schooliraha.irahaschool.util.combineColors
import com.schooliraha.irahaschool.R
import com.schooliraha.irahaschool.common.theme.IrahaSchoolTheme

@Composable
fun TextRow(
    modifier: Modifier = Modifier,
    icon: Painter? = null,
    iconTint: Color = contentColorFor(
        combineColors(
            MaterialTheme.colorScheme.secondaryContainer,
            MaterialTheme.colorScheme.surfaceVariant,
            angle = 0.3F,
        )
    ),
    endIcon: Painter? = null,
    endContent: @Composable (() -> Unit)? = null,
    endCaption: String? = null,
    iconInset: Boolean = true,
    text: String,
    wrapMainText: Boolean = false,
    description: String? = null,
    denseDescriptionOffset: Boolean = true,
    textStyle: TextStyle = MaterialTheme.typography.bodyLarge,
    descriptionTextStyle: TextStyle = MaterialTheme.typography.bodyMedium
        .copy(color = LocalContentColor.current.copy(alpha = 0.6f)),
) {
    Column(modifier) {
        Box(Modifier.padding(top = 16.dp)) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .heightIn(24.dp)
                    .padding(horizontal = 16.dp)
                    .height(IntrinsicSize.Min),
                verticalAlignment = Alignment.Top
            ) {
                Box(
                    Modifier
                        .padding(
                            start = if (!iconInset && icon === null) 8.dp else (24 + 16).dp,
                            top = 0.dp,
                            bottom = if (description !== null) 0.dp else 16.dp,
                        )
                        .heightIn(24.dp)
                        .widthIn(min = 100.dp)
                        .weight(1f),
                    contentAlignment = Alignment.CenterStart
                ) {
                    Text(
                        text = text,
                        style = textStyle,
                        softWrap = wrapMainText,
                        overflow = if (wrapMainText) TextOverflow.Visible else TextOverflow.Ellipsis,
                    )
                }

                if (endCaption !== null) {
                    Text(
                        modifier = Modifier.widthIn(max = 200.dp),
                        text = endCaption,
                        softWrap = false,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.bodyLarge,
                        color = LocalContentColor.current.copy(alpha = 0.6f),
                    )
                }

                if (endContent !== null || endIcon !== null) {
                    Box(
                        modifier = Modifier.fillMaxHeight(),
                        contentAlignment = Alignment.TopEnd,
                    ) {
                        Row(
                            Modifier
                                .height(24.dp)
                                .padding(start = 16.dp),
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            if (endContent !== null) {
                                endContent()
                                if (endIcon == null) {
                                    Spacer(modifier = Modifier.width(8.dp))
                                }
                            }
                            if (endIcon !== null) {
                                Spacer(modifier = Modifier.width(16.dp))
                                Icon(
                                    painter = endIcon,
                                    contentDescription = null
                                )
                            }
                        }
                    }
                }
            }

            if (icon !== null) {
                Box(
                    Modifier
                        .height(24.dp)
                        .width(56.dp)
                        .padding(horizontal = 16.dp),
                    contentAlignment = Alignment.CenterStart
                ) {
                    Icon(
                        painter = icon,
                        tint = iconTint,
                        contentDescription = null
                    )
                }
            }
        }
        if (description !== null) {
            Text(
                text = description,
                style = descriptionTextStyle,
                softWrap = true,
                modifier = Modifier
                    .padding(
                        start = if (!iconInset && icon === null) 24.dp else (24 + 16 * 2).dp,
                        top = if (denseDescriptionOffset) 0.dp else 8.dp,
                        end = 24.dp,
                        bottom = 16.dp,
                    )
            )
        }
    }
}

@Preview
@Composable
private fun Preview() {
    IrahaSchoolTheme {
        TextRow(
            text = "Text row",
        )
    }
}

@Preview
@Composable
private fun PreviewWithDescription() {
    IrahaSchoolTheme {
        TextRow(
            text = "Text row",
            description = "Description of text row",
        )
    }
}

@Preview()
@Composable
private fun PreviewTWithIcon() {
    IrahaSchoolTheme {
        TextRow(
            icon = painterResource(R.drawable.ic_launcher_background),
            text = "Text row",
        )
    }
}

@Preview()
@Composable
private fun PreviewWithDescriptionWithIcon() {
    IrahaSchoolTheme {
        TextRow(
            icon = painterResource(R.drawable.ic_launcher_background),
            text = "Text row",
            description = "Description of text row",
        )
    }
}

@Preview()
@Composable
private fun PreviewTWithIconWithEndContent() {
    IrahaSchoolTheme {
        TextRow(
            icon = painterResource(R.drawable.ic_launcher_background),
            text = "Text row",
            endCaption = "Very looooooooooooong end content as text"
        )
    }
}

@Preview()
@Composable
private fun PreviewWithIconWithEndContentWithLongTitle() {
    IrahaSchoolTheme {
        TextRow(
            icon = painterResource(R.drawable.ic_launcher_background),
            text = "Text row loooooooooooooooooooooooooooooooong",
            endCaption = "Very looooooooooooong end content as text"
        )
    }
}

@Preview()
@Composable
private fun PreviewWithIcons() {
    IrahaSchoolTheme {
        TextRow(
            icon = painterResource(R.drawable.ic_launcher_foreground),
            endIcon = painterResource(R.drawable.ic_launcher_foreground),
            text = "Text row loooooooooooooooooooooooooooooooong",
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview()
@Composable
private fun PreviewWithIconsWithChip() {
    IrahaSchoolTheme {
        TextRow(
            icon = painterResource(R.drawable.ic_launcher_background),
            endContent = {
                SuggestionChip(
                    label = { Text(text = "Suggestion") },
                    onClick = { /*TODO*/ },
                )
            },
            text = "Text row loooooooooooooooooooooooooooooooong",
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview()
@Composable
private fun PreviewWithIconsWithChipAndEndIcon() {
    IrahaSchoolTheme {
        TextRow(
            icon = painterResource(R.drawable.ic_launcher_background),
            endIcon = painterResource(R.drawable.ic_launcher_foreground),
            endContent = {
                SuggestionChip(
                    label = { Text(text = "Suggestion") },
                    onClick = { /*TODO*/ },
                )
            },
            text = "Text row loooooooooooooooooooooooooooooooong",
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview()
@Composable
private fun PreviewWithIconsWithChipWithWrapText() {
    IrahaSchoolTheme {
        TextRow(
            icon = painterResource(R.drawable.ic_launcher_background),
            endIcon = painterResource(R.drawable.ic_launcher_background),
            endContent = {
                SuggestionChip(
                    label = { Text(text = "Suggestion") },
                    onClick = { /*TODO*/ },
                )
            },
            wrapMainText = true,
            text = "Text row loooooooooooooooooooooooooooooooong",
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(name = "With icon, end content, end icon and description")
@Composable
private fun PreviewWithIconsWithChipWithDescriptionWithEndContentAndEnIcon() {
    IrahaSchoolTheme {
        TextRow(
            icon = painterResource(R.drawable.ic_launcher_foreground),
            endIcon = painterResource(R.drawable.ic_launcher_background),
            endContent = {
                SuggestionChip(
                    label = { Text(text = "Suggestion") },
                    onClick = { /*TODO*/ },
                )
            },
            wrapMainText = true,
            text = "Text row loooooooooooooooooooooooooooooooong",
            description = "Description looooooooooooooooooooooooooooooooooooong text",
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Preview(name = "With icon, end content, end icon and description")
@Composable
private fun PreviewWithIconsWithChipWithDescriptionWithEndContent() {
    IrahaSchoolTheme {
        TextRow(
            icon = painterResource(R.drawable.ic_launcher_background),
            endContent = {
                SuggestionChip(
                    label = { Text(text = "Suggestion") },
                    onClick = { /*TODO*/ },
                )
            },
            wrapMainText = true,
            text = "Text row",
            description = "Description loooooooooooooooooooooong text",
        )
    }
}