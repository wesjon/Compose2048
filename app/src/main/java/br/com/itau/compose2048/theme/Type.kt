package br.com.itau.compose2048.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
val typography = Typography(
    h1 = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 48.sp
    ),

    h2 = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp
    ),

    caption =  TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp
    ),
)