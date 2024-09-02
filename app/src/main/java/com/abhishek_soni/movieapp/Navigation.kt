package com.abhishek_soni.movieapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.abhishek_soni.movieapp.ui.screen.AppViewModel
import com.abhishek_soni.movieapp.ui.screen.HomeScreen
import com.abhishek_soni.movieapp.ui.screen.LoginScreen
import com.abhishek_soni.movieapp.ui.screen.MovieScreen

enum class Screen(val route: String) {
    Login("login"),
    Home("home"),
    Movie("movie"),
}

@Composable
fun AppNavigation(modifier: Modifier = Modifier) {
    val vm: AppViewModel = viewModel()
    val navController = rememberNavController()
    val homeState = vm.homeState.collectAsState().value
    val loginState = vm.loginState.collectAsState().value
    NavHost(navController = navController, startDestination = Screen.Login.route) {
        composable(Screen.Login.route){

            if (loginState.isLoginCompleted){
                navController.navigate(Screen.Home.route)
            }
            LoginScreen(
                modifier = modifier,
                state = loginState,
                onEvent = vm::onLoginEvent,
            )
        }
        composable(Screen.Home.route){
            HomeScreen(
                modifier = modifier,
                homeState = homeState,
                loginState = loginState,
                onEvent = vm::onHomeEvent,
            )
            if(homeState.selectedMovie!=null){
                navController.navigate(Screen.Movie.route)
            }
        }
        composable(Screen.Movie.route){
            if(homeState.selectedMovie == null){
                navController.popBackStack()
            }
            MovieScreen(
                modifier = modifier,
                homeState = homeState,
                loginState = loginState,
                onEvent = vm::onHomeEvent,
            )

        }
    }
}
