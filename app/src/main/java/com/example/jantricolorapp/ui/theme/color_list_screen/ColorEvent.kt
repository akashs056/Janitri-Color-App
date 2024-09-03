package com.example.jantricolorapp.ui.theme.color_list_screen

sealed class ColorEvent {
    data object OnAddColorClick: ColorEvent()
    data object OnSyncColorClick: ColorEvent()
}