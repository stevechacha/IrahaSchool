package com.schooliraha.irahaschool.presentation.settings

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.schooliraha.irahaschool.common.theme.IrahaSchoolTheme
import com.schooliraha.irahaschool.components.ButtonRow
import com.schooliraha.irahaschool.util.openInBrowser
import com.schooliraha.irahaschool.util.sendEmail
import com.schooliraha.irahaschool.R

const val BUG_REPORTER_SHEET = "bugReporter"

@Composable
fun BugReporter(onClose: () -> Unit = {}) {
    val context = LocalContext.current
    val navigationBarHeight = androidx.compose.ui.unit.max(
        WindowInsets.systemBars.asPaddingValues().calculateBottomPadding(),
        16.dp,
    )

    Surface {
        Column(modifier = Modifier.padding(bottom = navigationBarHeight)) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource(com.chuckerteam.chucker.R.string.icon_content_description),
                    style = MaterialTheme.typography.titleLarge,
                )
            }
            ButtonRow(
                icon = painterResource(R.drawable.ic_chevron_left),
                text = stringResource(com.chuckerteam.chucker.R.string.icon_content_description),
                onClick = {
                    openInBrowser(
                        context,
                        "https://github.com/danilkinkin/buckwheat/issues",
                    )
                    onClose()
                },
            )
            ButtonRow(
                icon = painterResource(R.drawable.ic_chevron_left),
                text = stringResource(R.string.copy_in_clipboard),
                onClick = {
                    sendEmail(
                        context,
                        arrayOf("hello@danilkinkin.com"),
                        "Buckwheat bug report",
                    )
                    onClose()
                },
            )
        }
    }
}

@Preview
@Composable
private fun PreviewDefault() {
    IrahaSchoolTheme {
        BugReporter()
    }
}