package com.schooliraha.irahaschool.presentation.settings

import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import androidx.hilt.navigation.compose.hiltViewModel
import com.schooliraha.irahaschool.components.CheckedRow
import com.schooliraha.irahaschool.R
import com.schooliraha.irahaschool.presentation.activity.appLocale
import com.schooliraha.irahaschool.common.theme.IrahaSchoolTheme
import com.schooliraha.irahaschool.components.AppViewModel
import com.schooliraha.irahaschool.components.ButtonRow
import com.schooliraha.irahaschool.components.PathState
import com.schooliraha.irahaschool.util.switchOverrideLocale
import com.schooliraha.irahaschool.util.titleCase
import kotlinx.coroutines.launch
import java.util.*

const val SETTINGS_CHANGE_LOCALE_SHEET = "settings.changeLocale"

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun LangSwitcher(appViewModel: AppViewModel = hiltViewModel()) {
    val context = LocalContext.current
    val configuration = LocalConfiguration.current
    val currentLocale = configuration.locales[0]

    ButtonRow(
        icon = painterResource(R.drawable.ic_language),
        text = stringResource(R.string.locale_label),
        onClick = {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                try {
                    val intent = Intent(android.provider.Settings.ACTION_APP_LOCALE_SETTINGS)
                    val uri: Uri = Uri.fromParts("package", context.packageName, null)
                    intent.data = uri
                    startActivity(context, intent, null)
                } catch (error: Error) {
                    appViewModel.openSheet(PathState(SETTINGS_CHANGE_LOCALE_SHEET))
                }
            } else {
                appViewModel.openSheet(PathState(SETTINGS_CHANGE_LOCALE_SHEET))
            }
        },
        endCaption = currentLocale.displayName.titleCase(),
    )
}

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun LangSwitcherDialog(onClose: () -> Unit) {
    val context = LocalContext.current
    val configuration = LocalConfiguration.current
    val overrideLocale = LocalContext.current.appLocale
    val coroutineScope = rememberCoroutineScope()

    val navigationBarHeight = androidx.compose.ui.unit.max(
        WindowInsets.systemBars.asPaddingValues().calculateBottomPadding(),
        16.dp,
    )

    fun handleSwitchLang(localeCode: String?) {
        coroutineScope.launch {
            switchOverrideLocale(context, localeCode)
            onClose()
        }
    }

    val currentLocale = configuration.locales[0]
    val locales = listOf(
        Locale("en"),
        Locale("ru"),
        Locale("uk"),
        Locale("be"),
        Locale("sv"),
        Locale("it"),
        Locale("cs"),
        Locale("fr"),
        Locale("cs"),
        Locale("es"),
        Locale("pt", "BR")
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
                    text = stringResource(R.string.locale_label),
                    style = MaterialTheme.typography.titleLarge,
                )
            }
            CheckedRow(
                text = stringResource(R.string.locale_system),
                checked = overrideLocale === null,
                onValueChange = { handleSwitchLang(null) },
            )
            locales.forEach { locale ->
                CheckedRow(
                    text = locale.getDisplayName(locale).titleCase(),
                    checked = overrideLocale !== null && locale.language === currentLocale.language,
                    onValueChange = { handleSwitchLang(locale.language) },
                )
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.N)
@Preview
@Composable
private fun Preview() {
    IrahaSchoolTheme {
        Surface {
            LangSwitcher()
        }
    }
}
