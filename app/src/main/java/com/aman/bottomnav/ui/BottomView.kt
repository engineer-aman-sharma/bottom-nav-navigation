package com.aman.bottomnav.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.compose.currentBackStackEntryAsState

data class BottomNavItem(
    val route: String,
    val icon: ImageVector,
    val label: String
)

val bottomNavItems = listOf(
    BottomNavItem("first", Icons.Default.Home, "Home"),
    BottomNavItem("second", Icons.Default.Person, "Profile"),
    BottomNavItem("third", Icons.Default.Settings, "Settings"),
    BottomNavItem("fourth", Icons.Default.Call, "Calls")
)

@Composable
fun BottomView(navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    if (shouldShowBottomBar(currentDestination)) {
        NavigationBar {
            bottomNavItems.forEach { item ->
                NavigationBarItem(
                    selected = currentDestination?.route == item.route,
                    onClick = {
                        if (currentDestination?.route != item.route) {
                            navController.navigate(item.route) {
                                popUpTo(navController.graph.startDestinationId) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    },
                    icon = { Icon(item.icon, contentDescription = item.label) },
                    label = { Text(item.label) }
                )
            }
        }
    }
}

fun shouldShowBottomBar(destination: NavDestination?): Boolean {
    return bottomNavItems.any { it.route == destination?.route }
}