package com.kamelfardi.formula1.ui.navigation

sealed class Screens(val route : String) {
    object Home : Screens("home_route")
    object F1 : Screens("f1_route")
    object Notification : Screens("notification_route")
    object Profile : Screens("profile_route")
}