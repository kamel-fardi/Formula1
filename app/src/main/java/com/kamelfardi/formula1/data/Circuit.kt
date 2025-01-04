package com.kamelfardi.formula1.data

import androidx.compose.ui.graphics.Brush

import android.graphics.Color
import com.google.gson.Gson

data class Circuit(
    val circuitId: String? = null,
    val url: String? = null,
    val circuitName: String? = null,
    val location: Location? = null,
    val date: String? = null,
    val color: Brush? = null
) {
    companion object {
        private val gson = Gson()

        // Function to convert JSON string to Circuit object
        fun fromJson(jsonString: String): Circuit {
            return gson.fromJson(jsonString, Circuit::class.java)
        }

        // Function to convert Circuit object to JSON string
        fun toJson(circuit: Circuit): String {
            return gson.toJson(circuit)
        }
    }
}

