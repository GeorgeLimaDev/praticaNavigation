package com.example.pratica_navigation.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun MainScreen(modifier: Modifier = Modifier, onLogoffClick: () -> Unit) {
    Column (horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier.fillMaxSize()) {
        Text(text = "You have successfully logged in")
        Button(onClick = { onLogoffClick() }) {
            Text("Logout")
        }
    }
}