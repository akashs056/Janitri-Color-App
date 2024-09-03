package com.example.jantricolorapp.utils

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
fun formatTimestampToDate(timestamp: Long): String {
    val formatter = DateTimeFormatter.ofPattern(AppConstants.DATE_PATTERN)
        .withZone(ZoneId.systemDefault())

    val instant = Instant.ofEpochMilli(timestamp)
    return formatter.format(instant)
}