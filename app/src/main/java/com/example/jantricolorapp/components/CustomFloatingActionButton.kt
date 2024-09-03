package com.example.jantricolorapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jantricolorapp.utils.AppConstants
import com.example.jantricolorapp.ui.theme.fontFamily

@Composable
fun CustomFloatingActionButton(
    modifier: Modifier = Modifier,
    text: String,
    icon: ImageVector,
    onClick: () -> Unit,
) {
    Box(
        modifier = modifier
            .border(
                width = 0.dp,
                color = AppConstants.FAB_BORDER_COLOR,
                shape = RoundedCornerShape(AppConstants.FAB_CORNER.dp)
            )
            .background(AppConstants.FAB_BACKGROUND_COLOR, shape = RoundedCornerShape(AppConstants.FAB_CORNER.dp))
            .height(AppConstants.FAB_HEIGHT.dp)
            .width(AppConstants.FAB_WIDTH.dp)
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            Text(
                text = text,
                color = AppConstants.FAB_TEXT_COLOR,
                fontSize = AppConstants.FAB_TEXT_SIZE.sp,
                fontFamily = fontFamily,
                fontWeight = FontWeight.Normal,
                modifier = Modifier.padding(end = AppConstants.FAB_TEXT_PADDING.dp)
            )
            Box(
                modifier = Modifier
                    .size(AppConstants.ICON_SIZE.dp)
                    .background(
                        color = AppConstants.ICON_BACKGROUND_COLOR,
                        shape = CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    icon,
                    contentDescription = AppConstants.FAB_ICON_DESCRIPTION,
                    tint = Color.White
                )
            }
        }
    }
}