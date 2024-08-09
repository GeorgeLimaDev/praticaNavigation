package com.example.pratica_navigation.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun LoginScreen(modifier: Modifier = Modifier, onSignInClick: () -> Unit) {
    var username by remember {mutableStateOf("")}
    var password by remember {mutableStateOf("")}
    var errorMessage by remember { mutableStateOf<String?>(null) }

    Column (horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier.fillMaxSize()) {
        TextField(value = username, onValueChange = {username = it},
            placeholder = {Text("Username")}
        )
        Spacer(modifier = Modifier.height(10.dp))
        TextField(value = password, onValueChange = {password = it},
            placeholder = {Text("Password")},
            visualTransformation = PasswordVisualTransformation(),
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            if (username ==  password) {
                onSignInClick()
            } else {
                errorMessage = "Either Username or Password is wrong"
            }
        }) {
            Text("Login")
        }
        errorMessage?.let {
            Text(
                text = it,
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier.padding(top = 8.dp)
            )
            LaunchedEffect(Unit) {
                delay(3000)
                errorMessage = null
            }
        }
    }
}