package com.kamelfardi.formula1.data

import android.graphics.drawable.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AdUnits
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.SportsScore
import androidx.compose.ui.graphics.vector.ImageVector
import com.kamelfardi.formula1.ui.navigation.Screens

data class BottomNavigation(
    val title: String ="",
    val icon: ImageVector = Icons.Filled.Home,
    val route : String = ""
)
{
    //function to get the list of bottomNavigationItems
    fun bottomNavigationItems() : List<BottomNavigation> {
        return listOf(
            BottomNavigation(
                title = "Home",
                icon = Icons.Filled.Home,
                route = Screens.Home.route
            ),
            BottomNavigation(
                title = "F1",
                icon = Icons.Filled.SportsScore,
                route = Screens.F1.route
            ),
            BottomNavigation(
                title = "Social",
                icon = Icons.Filled.AdUnits,
                route = Screens.Social.route
            ),
            BottomNavigation(
                title = "Profile",
                icon = Icons.Filled.AccountCircle,
                route = Screens.Profile.route
            ),
        )
    }
}
