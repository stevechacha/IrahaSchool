package com.schooliraha.irahaschool.presentation.home

import android.os.Build
import androidx.activity.result.ActivityResultRegistryOwner
import androidx.annotation.DrawableRes
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.LocalOverscrollConfiguration
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeGesturesPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.schooliraha.irahaschool.R
import com.schooliraha.irahaschool.bottomnav.BottomNavigationBar
import com.schooliraha.irahaschool.bottomnav.RootNavGraph
import com.schooliraha.irahaschool.components.AppViewModel
import com.schooliraha.irahaschool.components.PathState
import com.schooliraha.irahaschool.presentation.activity.StatusBarStub
import com.schooliraha.irahaschool.presentation.financial.FINANCIAL_SCREEN_ROUTE
import com.schooliraha.irahaschool.presentation.notice_board.NOTICE_BOARD_SCREEN_ROUTE
import com.schooliraha.irahaschool.presentation.settings.SETTINGS_CHANGE_THEME_SHEET
import com.schooliraha.irahaschool.presentation.settings.SETTINGS_SHEET
import com.schooliraha.irahaschool.presentation.staff.STAFF_SCREEN_ROUTE
import com.schooliraha.irahaschool.presentation.students.STUDENTS_SCREEN_ROUTE
import com.schooliraha.irahaschool.presentation.teachers.TEACHERS_SCREEN_ROUTE


@RequiresApi(Build.VERSION_CODES.P)
@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    navController: NavHostController,
) {

}



@Composable
fun HomeCardItem(
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int,
    title: String,
    onClick: (String) -> Unit,
) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .wrapContentSize()
            .background(Color.Transparent)
            .clickable(MutableInteractionSource(), null) { onClick(title) },
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .border(
                    color = Color.LightGray,
                    width = 1.dp,
                    shape = RoundedCornerShape(12.dp)
                )
                .size(80.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painterResource(id = icon),
                modifier = Modifier.size(30.dp),
                contentScale = ContentScale.Crop,
                contentDescription = "Icon"
            )
        }
        Text(
            text = title.uppercase(),
            fontSize = 12.sp,
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.W500,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )

    }
}

