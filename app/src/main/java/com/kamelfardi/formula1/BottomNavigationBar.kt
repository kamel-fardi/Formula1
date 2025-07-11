package com.kamelfardi.formula1

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.kamelfardi.formula1.data.BottomNavigation
import com.kamelfardi.formula1.ui.Screens.F1Screen
import com.kamelfardi.formula1.ui.navigation.Screens
import com.kamelfardi.formula1.ui.screens.home.HomeScreen
import com.kamelfardi.formula1.ui.screens.notification.NotificationScreen
import com.kamelfardi.formula1.ui.screens.profile.ProfileScreen
import com.kamelfardi.formula1.ui.screens.social.SocialScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavigationBar() {

    /**
     * by using the rememberNavController()
     * we can get the instance of the navController
     */
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination


//scaffold to hold our bottom navigation Bar
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text("Formula 1 AR") },

                actions = {
                    IconButton(onClick = { /* Handle search icon click */ }) {
                        Icon(
                            imageVector = Icons.Default.Notifications,
                            contentDescription = "Notification Icon"
                        )
                    }
                }
            )
        },

        bottomBar = {
            NavigationBar {
                //getting the list of bottom navigation items for our data class
                BottomNavigation().bottomNavigationItems().forEachIndexed { _, navigationItem ->

                    //iterating all items with their respective indexes
                    NavigationBarItem(
                        selected = navigationItem.route == currentDestination?.route,
                        label = {
                            Text(navigationItem.title)
                        },
                        icon = {
                            Icon(
                                navigationItem.icon,
                                contentDescription = navigationItem.title
                            )
                        },
                        onClick = {
                            navController.navigate(navigationItem.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Screens.Home.route,
            modifier = Modifier.padding(paddingValues = paddingValues)
        ) {
            composable(Screens.Home.route) {
                //call our composable screens here
                HomeScreen(navController)
            }
            composable(Screens.F1.route) {
                F1Screen(navController)
                //call our composable screens here
            }
            composable(Screens.Social.route) {
                SocialScreen(navController)
                //call our composable screens here
            }
            composable(Screens.Profile.route) {
                //call our composable screens here
                ProfileScreen(navController)
            }

        }
        //We need to setup our NavHost in here
    }
}

















