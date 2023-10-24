package com.schooliraha.irahaschool.presentation.settings

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.foundation.text.appendInlineContent
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.danilkinkin.buckwheat.base.ClickableText
import com.danilkinkin.buckwheat.base.DescriptionButton
import com.schooliraha.irahaschool.R
import com.schooliraha.irahaschool.common.theme.IrahaSchoolTheme
import com.schooliraha.irahaschool.components.AppViewModel
import com.schooliraha.irahaschool.components.PathState
import com.schooliraha.irahaschool.util.openInBrowser

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun About(
    modifier: Modifier = Modifier,
    appViewModel: AppViewModel = hiltViewModel(),
) {
    val context = LocalContext.current
    val configuration = LocalConfiguration.current

    Card(
        modifier = modifier,
        shape = MaterialTheme.shapes.extraLarge
    ) {
        val contentColor = LocalContentColor.current

        Column(Modifier.padding(16.dp)) {
            Text(
                text = stringResource(R.string.about),
                style = MaterialTheme.typography.titleLarge,
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = stringResource(R.string.description),
                style = MaterialTheme.typography.bodyMedium,
            )
            Spacer(modifier = Modifier.height(8.dp))

            val annotatedString = buildAnnotatedString {
                withStyle(style = SpanStyle(color = contentColor)) {
                    append("${stringResource(R.string.developer)} ")
                }

                pushStringAnnotation(
                    tag = "developer",
                    annotation = "https://danilkinkin.com",
                )
                withStyle(
                    style = SpanStyle(color = MaterialTheme.colorScheme.primary)
                ) {
                    append("@danilkinkin ")
                }

                appendInlineContent("openInBrowser")

                pop()
            }

            ClickableText(
                text = annotatedString,
                inlineContent = mapOf(
                    "openInBrowser" to InlineTextContent(
                        Placeholder(
                            MaterialTheme.typography.bodyLarge.fontSize,
                            MaterialTheme.typography.bodyLarge.fontSize,
                            PlaceholderVerticalAlign.TextCenter,
                        )
                    ) {
                        Icon(
                            tint = MaterialTheme.colorScheme.primary,
                            painter = painterResource(R.drawable.ic_chevron_left),
                            contentDescription = null,
                        )
                    }
                ),
                style = MaterialTheme.typography.bodyLarge,
                onClick = { offset ->
                    annotatedString.getStringAnnotations(
                        tag = "developer",
                        start = offset,
                        end = offset,
                    ).firstOrNull()?.let {
                        openInBrowser(
                            context,
                            "https://danilkinkin.com",
                        )
                    }

                },
            )
            Spacer(modifier = Modifier.height(24.dp))
            DescriptionButton(
                title = { Text(stringResource(R.string.contribute)) },
                icon = painterResource(R.drawable.ic_launcher_background),
                colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primary),
                contentPadding = PaddingValues(
                    start = 20.dp,
                    top = 12.dp,
                    bottom = 12.dp,
                    end = 12.dp,
                ),
                onClick = {
                    val currentLocale = configuration.locales[0].language

                    openInBrowser(
                        context,
                        if (currentLocale === "ru") {
                            "https://buckwheat.app/ru/contribute"
                        } else {
                            "https://buckwheat.app/contribute"
                        },
                    )
                },
            )
            Spacer(modifier = Modifier.height(8.dp))
            DescriptionButton(
                title = { Text(stringResource(R.string.report_bug)) },
                icon = painterResource(R.drawable.ic_launcher_background),
                colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primary),
                contentPadding = PaddingValues(
                    start = 20.dp,
                    top = 12.dp,
                    bottom = 12.dp,
                    end = 12.dp,
                ),
                onClick = {
                    appViewModel.openSheet(PathState(BUG_REPORTER_SHEET))
                },
            )
        }
    }
}

@RequiresApi(Build.VERSION_CODES.N)
@Preview(name = "Default")
@Composable
private fun PreviewDefault() {
    IrahaSchoolTheme {
        About()
    }
}

@RequiresApi(Build.VERSION_CODES.N)
@Preview(name = "Night mode", uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun PreviewNightMode() {
    IrahaSchoolTheme {
        About()
    }
}