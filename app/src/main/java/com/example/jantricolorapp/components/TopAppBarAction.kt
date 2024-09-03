package com.example.jantricolorapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.jantricolorapp.R
import com.example.jantricolorapp.utils.AppConstants
import com.example.jantricolorapp.ui.theme.fontFamily

@Composable
fun TopAppBarAction(
    pendingCount: Int,
    onSyncColorClick: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(end = AppConstants.PADDING_END.dp)
            .height(AppConstants.ACTION_ROW_HEIGHT.dp)
            .width(AppConstants.ACTION_ROW_WIDTH.dp)
            .background(
                AppConstants.ACTION_ROW_BACKGROUND_COLOR,
                shape = RoundedCornerShape(AppConstants.ACTION_ROW_CORNER.dp)
            )
    ) {
        Text(
            text = "$pendingCount",
            color = Color.White,
            fontFamily = fontFamily,
            fontWeight = FontWeight.Normal,
            modifier = Modifier
                .padding(start = 12.dp)
        )
        IconButton(onClick = onSyncColorClick) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_sync_icon),
                contentDescription = "Sync icon",
            )
        }
    }
}
