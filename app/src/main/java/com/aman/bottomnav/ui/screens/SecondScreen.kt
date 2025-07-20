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
fun SecondScreen(nav: NavController) {
    val sendData = "Second Screen sent 123098"

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Second Screen\n\n it will send 123098",
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