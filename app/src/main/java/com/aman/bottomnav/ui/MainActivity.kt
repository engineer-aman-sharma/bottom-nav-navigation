package com.aman.bottomnav.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.aman.bottomnav.ui.theme.ThemeByAman

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val nav = rememberNavController()
            MyApp(nav)
        }
    }

}

@Composable
fun MyApp(nav: NavHostController) {
    ThemeByAman {
        Scaffold(
            modifier = Modifier,
            bottomBar = {
                BottomView(nav)
            }
        ) { innerPad ->
            NavGraph(innerPad, nav)
        }
    }
}

@Preview
@Composable
fun mainpreview() {
    MyApp(rememberNavController())
}