package com.abhishek_soni.movieapp.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController


@Composable
fun RegisterScreen(navController: NavHostController) {

    var fullmane by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        MaterialTheme.colorScheme.onPrimary,
                        MaterialTheme.colorScheme.secondary,
                        MaterialTheme.colorScheme.primary,
//                        MaterialTheme.colorScheme.onSurfaceVariant,
//                        MaterialTheme.colorScheme.inverseOnSurface,
                    )
                )
            ),
        contentAlignment = Alignment.Center
    ){
        Column(
            modifier = Modifier.
            padding(20.dp)
//                .width(300.dp)
                .background(
                    MaterialTheme.colorScheme.surface,
                    shape = MaterialTheme.shapes.large,
                )
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                text = "Register",
                style = MaterialTheme.typography.headlineSmall
            )
            HorizontalDivider()
            OutlinedTextField(
                value = fullmane,
                onValueChange = { fullmane = it },
                label = { Text("Full Name") },
                leadingIcon = { Icon(Icons.Default.Person, contentDescription = null) }
            )
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email Id") },
                leadingIcon = { Icon(Icons.Default.Email, contentDescription = null) }
            )
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                leadingIcon = { Icon(Icons.Default.Lock, contentDescription = null) }
            )
            OutlinedTextField(
                value = confirmPassword,
                onValueChange = { confirmPassword = it },
                label = { Text("Confirm Password") },
                leadingIcon = { Icon(Icons.Default.Lock, contentDescription = null) }
            )
            HorizontalDivider()
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                ClickableText(
                    text = AnnotatedString("Already have Acccount") ,
                    onClick = {
                        navController.navigate("LoginScreen")
                    })
            }
            ExtendedFloatingActionButton(
                modifier = Modifier.align(Alignment.End),
                onClick = {
                    navController.navigate("HomeScreen")
                }) {
                Icon(imageVector = Icons.Default.Person, contentDescription = "Login")
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "Login to Account")
            }


        }
    }


}
