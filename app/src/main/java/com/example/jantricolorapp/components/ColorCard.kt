package com.example.jantricolorapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jantricolorapp.utils.AppConstants
import com.example.jantricolorapp.utils.drawUnderline
import com.example.jantricolorapp.ui.theme.fontFamily

@Composable
fun ColorCard(hexColor: String, date: String) {
    val color = Color(android.graphics.Color.parseColor(hexColor))
    Box(
        modifier = Modifier
            .padding(AppConstants.COLOR_CARD_PADDING.dp)
            .background(color = color, shape = RoundedCornerShape(AppConstants.COLOR_CARD_CORNER.dp))
            .height(AppConstants.COLOR_CARD_HEIGHT.dp)
            .fillMaxWidth(),
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(AppConstants.TEXT_PADDING.dp)
        ) {
            Text(
                text = hexColor,
                color = Color.White,
                fontSize = AppConstants.TEXT_SIZE.sp,
                fontFamily = fontFamily,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.drawUnderline()
            )
        }
        Row(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(AppConstants.TEXT_PADDING.dp)
        ) {
            Spacer(modifier = Modifier.weight(1f))
            Column(
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    text = AppConstants.CREATED_AT_TEXT,
                    color = Color.White,
                    fontFamily = fontFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = AppConstants.SMALL_TEXT_SIZE.sp,
                    lineHeight = AppConstants.SMALL_TEXT_LINE_HEIGHT.sp
                )
                Text(
                    text = date,
                    color = Color.White,
                    fontFamily = fontFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = AppConstants.SMALL_TEXT_SIZE.sp,
                    lineHeight = AppConstants.SMALL_TEXT_LINE_HEIGHT.sp
                )
            }
        }
    }
}