package com.aman.bottomnav.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun FourthScreen(nav: NavController) {
    val sendData = "Fourth Screen sent 77249"

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Fourth Screen\n\n it will send 77249",
            fontSize = 30.sp
        )
        ExtendedFloatingActionButton(
            onClick = { nav.navigate("details/${sendData}") },
            text = { Text("Navigate") },
            icon = {
                Icon(
                    Icons.AutoMirrored.Filled.ArrowForward,
                    contentDescription = "navigate"
                )
            },
            modifier = Modifier
                .padding(16.dp)
        )
    }
}