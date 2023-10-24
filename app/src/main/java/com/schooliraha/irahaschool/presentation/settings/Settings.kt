package com.schooliraha.irahaschool.presentation.settings

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.schooliraha.irahaschool.R
import com.schooliraha.irahaschool.common.theme.IrahaSchoolTheme

const val SETTINGS_SHEET = "settings"

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun Settings(onClose: () -> Unit = {}) {
    val navigationBarHeight = androidx.compose.ui.unit.max(
        WindowInsets.systemBars.asPaddingValues().calculateBottomPadding(),
        16.dp,
    )

    Surface {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource(R.string.settings_title),
                    style = MaterialTheme.typography.titleLarge,
                )
            }
            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .padding(bottom = navigationBarHeight)
            ) {
                ThemeSwitcher()
                LangSwitcher()
                /* TextRow(
                     text = stringResource(R.string.version, BuildConfig.VERSION_NAME),
                 )*/
                About(Modifier.padding(start = 16.dp, end = 16.dp))
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.N)
@Preview(name = "Default")
@Composable
private fun PreviewDefault() {
    IrahaSchoolTheme {
        Settings()
    }
}

@RequiresApi(Build.VERSION_CODES.N)
@Preview(name = "Night mode", uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun PreviewNightMode() {
    IrahaSchoolTheme {
        Settings()
    }
}
