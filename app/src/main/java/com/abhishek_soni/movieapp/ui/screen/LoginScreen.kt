package com.abhishek_soni.movieapp.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController


sealed class LoginEvent {
    data class OnUsernameChange(val name: String) : LoginEvent()
    data class OnPasswordChange(val pwd: String) : LoginEvent()
    data object OnLoginClick : LoginEvent()
    data object OnLogoutClick : LoginEvent()
}

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    state: LoginState,
    onEvent: (LoginEvent) -> Unit = {},
) {


    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        MaterialTheme.colorScheme.onPrimary,
                        MaterialTheme.colorScheme.secondary,
                        MaterialTheme.colorScheme.primary,
                        MaterialTheme.colorScheme.onSurfaceVariant,
                        MaterialTheme.colorScheme.inverseOnSurface,
                    )
                )
            ),
        contentAlignment = Alignment.Center
    ) {

        Column(
            modifier = Modifier
                .width(300.dp)
                .background(
                    MaterialTheme.colorScheme.surface,
                    shape = MaterialTheme.shapes.large,
                )
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            Text(
                text = "Login ",
                style = MaterialTheme.typography.headlineSmall
            )
            HorizontalDivider()
            OutlinedTextField(
                value = state.username,
                label = { Text(text = "Username") },
                onValueChange = {
                    onEvent(LoginEvent.OnUsernameChange(it))
                },
                isError = state.isError
            )
            OutlinedTextField(
                value = state.password,
                label = { Text(text = "Password") },
                visualTransformation = PasswordVisualTransformation(),
                onValueChange = {
                    onEvent(LoginEvent.OnPasswordChange(it))
                },
                isError = state.isError
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Forgot Password", modifier = Modifier.clickable{})
//                Spacer(modifier = Modifier.width(8.dp))
                Text("Sign Up",modifier = Modifier.clickable{})
            }
            ExtendedFloatingActionButton(
                modifier = Modifier.align(Alignment.End),
                onClick = {
                    onEvent(LoginEvent.OnLoginClick)
                }) {
                Icon(imageVector = Icons.Default.Person, contentDescription = "Login")
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "Login to Account")
            }
        }

    }
}
