package com.kamelfardi.formula1.data

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import com.google.gson.Gson
import com.google.gson.JsonElement
import com.google.gson.JsonObject

data class Constructor(
    val constructorId: String? = null,
    val url: String? = null,
    val name: String? = null,
    val points: String? = null,
    val position: String? = null,
    val wins: String? = null,
    val color: String? = null,  // We will store the color as a string (Hex code)
    val nationality: String? = null
) {
    companion object {
        private val gson = Gson()

        // Function to convert JSON string to Constructor object
        fun fromJson(jsonString: String): Constructor {
            return gson.fromJson(jsonString, Constructor::class.java)
        }

        // Function to convert Constructor object to JSON string
        fun toJson(constructor: Constructor): String {
            return gson.toJson(constructor)
        }

        // Function to convert a Hex color string to Brush
        fun colorFromString(color: String): Brush {
            return Brush.linearGradient(listOf(Color(android.graphics.Color.parseColor(color))))
        }

        // Function to convert Brush to Hex string (to be used before saving)
        fun colorToString(color: Brush): String {
            return Color.Black.toArgb().toString() // Just an example, convert Brush to Hex or ARGB value
        }
    }

    // You can convert color from Hex when needed
    fun getColorBrush(): Brush {
        return color?.let { colorFromString(it) } ?: Brush.linearGradient(listOf(Color.Gray))
    }
}


