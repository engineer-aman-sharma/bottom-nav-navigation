package com.aman.bottomnav.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.aman.bottomnav.ui.screens.DetailScreen
import com.aman.bottomnav.ui.screens.FirstScreen
import com.aman.bottomnav.ui.screens.FourthScreen
import com.aman.bottomnav.ui.screens.SecondScreen
import com.aman.bottomnav.ui.screens.ThirdScreen

@Composable
fun NavGraph(innerPad: PaddingValues, nav: NavHostController) {
    NavHost(
        modifier = Modifier.padding(innerPad),
        navController = nav,
        startDestination = "first"
    ) {
        composable("first") {
            FirstScreen(nav)
        }

        composable("second") {
            SecondScreen(nav)
        }

        composable("third") {
            ThirdScreen(nav)
        }

        composable("fourth") {
            FourthScreen(nav)
        }

        // Other top-level screens not in bottom bar
        composable("details/{data}") { backStackEntry ->
            val data = backStackEntry.arguments?.getString("data") ?: "nothing was sent"
            DetailScreen(nav, data)
        }

    }
}