package com.abhishek_soni.movieapp.ui.screen

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.abhishek_soni.movieapp.modal.getMovies


@Composable
fun MovieScreen(
//    navController: NavHostController,
    modifier: Modifier = Modifier,
    homeState: HomeState,
    loginState: LoginState,
    onEvent: (HomeEvent) -> Unit = {},

    ) {
    BackHandler {
        onEvent(HomeEvent.OnMovieClick(null))
    }
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .padding(8.dp)
                        .background(Color.Gray, shape = CircleShape),
                    contentAlignment = Alignment.Center,
                ) {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "person"
                    )
                }
                Text(
                    text = "Hello ${loginState.username}",
                    fontSize = 20.sp,
                )
            }

        }
        AsyncImage(
            homeState.selectedMovie?.imgUrl,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .clickable {  },
        )
        Text(
            text = homeState.selectedMovie?.title ?: "No Title",
            style = MaterialTheme.typography.headlineLarge
        )
        Text(
            text = homeState.selectedMovie?.year.toString(),
            style = MaterialTheme.typography.bodyMedium
        )
        Text(
            text = homeState.selectedMovie?.director ?: "No Director",
            style = MaterialTheme.typography.bodySmall
        )
        Text(
            text = homeState.selectedMovie?.body ?: "No Body",
            style = MaterialTheme.typography.bodyMedium
        )
    }
}
