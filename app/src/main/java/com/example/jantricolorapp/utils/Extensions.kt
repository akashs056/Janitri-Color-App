package com.example.jantricolorapp.utils

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

fun Modifier.drawUnderline() = this.then(
    Modifier.drawBehind {
        val strokeWidth = 2.dp.toPx()
        val y = (size.height - strokeWidth / 2) + 8
        drawLine(
            color = Color.White,
            start = Offset(0f, y),
            end = Offset(size.width + 50, y),
            strokeWidth = strokeWidth
        )
    }
)