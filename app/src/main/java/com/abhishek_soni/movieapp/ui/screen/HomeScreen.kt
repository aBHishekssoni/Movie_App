package com.abhishek_soni.movieapp.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.abhishek_soni.movieapp.R
import com.abhishek_soni.movieapp.modal.Movie




sealed class HomeEvent {
    data class OnMovieClick(val movie: Movie?) : HomeEvent()
}

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    homeState: HomeState,
    loginState: LoginState,
    onEvent: (HomeEvent) -> Unit = {},
    onLoginEvent: (LoginEvent) -> Unit = {}
) {
    Column(
        modifier = modifier.background(MaterialTheme.colorScheme.background),

    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth().background(Color.Gray.copy(alpha = 0.2f))
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
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(8.dp)
        ) {
            items(homeState.movieList) { movie ->
                MovieCard(movie = movie) { selectedMovie ->
                    onEvent(HomeEvent.OnMovieClick(selectedMovie))
                }
            }
        }
    }
}

@Composable
fun MovieCard(
    modifier: Modifier = Modifier,
    movie: Movie?,
    onMovieSelected: (Movie) -> Unit,

) {

    Card(
        onClick = {
            if (movie != null) {
                onMovieSelected(movie)
            }
        },
        modifier = Modifier
            .fillMaxSize()
            .padding(4.dp, 8.dp),

        ) {
        Box(modifier = Modifier.fillMaxSize()) {
            if (movie != null) {
                AsyncImage(
                    movie.imgUrl,
                    contentDescription = movie.title,
                    modifier = Modifier.height(300.dp),
                    contentScale = ContentScale.Crop
                )
            }
            Image(
                painter = painterResource(id = R.drawable.play_button), contentDescription = null,
                modifier = Modifier.size(260.dp).padding(start = 30.dp, end  = 40.dp),Alignment.Center,
            )

            Column(
                modifier = Modifier.align(Alignment.BottomStart)
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Gray,
                            ),
                            startY = 10f,
                            endY = 150f,
                        )
                    )
                    .padding(8.dp)
            ) {
//                Image(
//                    painter = painterResource(id = R.drawable.play_button), contentDescription = null,
//                    modifier = Modifier.size(90.dp),Alignment.Center,
//                )

                if (movie != null) {
                    Text(
                        text = movie.title, fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 8.dp)
                        .padding(bottom = 8.dp)
                ) {

//                    if (movie != null) {
//                        Text(
//                            text = movie.director,
//                            fontSize = 12.sp,
//                        )
//                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
//                        Icon(
//                            imageVector = Icons.Default.PlayArrow,
//                            modifier = Modifier.size(16.dp),
//                            contentDescription = null
//                        )
//                        Spacer(modifier = Modifier.width(2.dp))
                        if (movie != null) {
                            Text(
                                text = "${movie.year}",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }
        }
    }
}
