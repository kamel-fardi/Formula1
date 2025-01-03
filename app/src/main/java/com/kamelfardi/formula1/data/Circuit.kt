package com.kamelfardi.formula1.data

import androidx.compose.ui.graphics.Brush

data class Circuit(
    val circuitId: String,
    val url: String,
    val circuitName: String,
    val Location: Location,
    val date : String,
    val color: Brush
)
