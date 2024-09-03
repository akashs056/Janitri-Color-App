package com.example.jantricolorapp.ui.theme.color_list_screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.jantricolorapp.utils.AppConstants
import com.example.jantricolorapp.utils.formatTimestampToDate
import com.example.jantricolorapp.components.ColorCard
import com.example.jantricolorapp.components.CustomFloatingActionButton
import com.example.jantricolorapp.components.TopAppBarAction
import com.example.jantricolorapp.ui.theme.fontFamily

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ColorListScreen(
    viewModel: ColorListScreenViewModel = hiltViewModel()
) {
    val allColors = viewModel.allColors.collectAsState(initial = emptyList())
    val pendingCount by viewModel.pendingCount.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = AppConstants.TOP_APP_BAR_TITLE,
                        fontFamily = fontFamily,
                        fontWeight = FontWeight.Normal,
                    )
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = AppConstants.TOP_APP_BAR_COLOR,
                    titleContentColor = Color.White
                ),
                actions = {
                    TopAppBarAction(
                        pendingCount = pendingCount,
                        onSyncColorClick = { viewModel.onEvent(ColorEvent.OnSyncColorClick) }
                    )
                }
            )
        },
        floatingActionButton = {
            CustomFloatingActionButton(
                text = AppConstants.FAB_TEXT,
                icon = Icons.Default.Add,
                onClick = {
                    viewModel.onEvent(ColorEvent.OnAddColorClick)
                },
                modifier = Modifier
            )
        }
    ) { padding ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(AppConstants.GRID_COLUMNS),
            modifier = Modifier
                .padding(padding)
                .padding(AppConstants.GRID_PADDING.dp)
        ) {
            items(allColors.value) { color ->
                ColorCard(hexColor = color.color, date = formatTimestampToDate(color.timestamp))
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun PreviewColorAppUI() {
    ColorListScreen()
}
