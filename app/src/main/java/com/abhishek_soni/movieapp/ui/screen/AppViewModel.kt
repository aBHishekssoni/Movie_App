package com.abhishek_soni.movieapp.ui.screen

import androidx.lifecycle.ViewModel
import com.abhishek_soni.movieapp.modal.Movie
import com.abhishek_soni.movieapp.modal.getMovies
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class LoginState(
    val username: String = "",
    val password: String = "",
    val isLoginCompleted: Boolean = false,
    val isError: Boolean = false,
)

data class HomeState(
    val movieList: List<Movie> = getMovies(),
    val selectedMovie: Movie? = null,
)

class AppViewModel() : ViewModel() {
    private val _loginState = MutableStateFlow(LoginState())
    val loginState = _loginState.asStateFlow()

    private val _homeState = MutableStateFlow((HomeState()))
    val homeState = _homeState.asStateFlow()

    fun onHomeEvent(event: HomeEvent) {
        when (event) {
            is HomeEvent.OnMovieClick -> {
                _homeState.update {
                    it.copy(selectedMovie = event.movie)
                }
            }
        }
    }

    fun onLoginEvent(event: LoginEvent) {
        when (event) {
            LoginEvent.OnLoginClick -> {
                checkLogin()
            }

            is LoginEvent.OnPasswordChange -> {
                _loginState.update { it.copy(password = event.pwd) }
            }

            is LoginEvent.OnUsernameChange -> {
                _loginState.update { it.copy(username = event.name) }
            }

            LoginEvent.OnLogoutClick -> {
                _loginState.update{
                    it.copy(isLoginCompleted = false)
                }
            }
        }
    }

    private fun checkLogin() {
        val state = _loginState.value
        val authData = mapOf(
            "user" to "12345",
            "tester" to "test",
            "Abhishek" to "12345",
            "Sonu" to "12345",
            "Aryan" to "54321",
            "Pushkar" to "12345",
            "Ayush" to "54321",
            "Tushar" to "12345",
            "Ram" to "54321",
            "" to "",
            "a" to "1",


        )
        authData.forEach { (un, pw) ->
            if (state.username == un && state.password == pw) {
                _loginState.update {
                    it.copy(
                        isLoginCompleted = true,
                        isError = false
                    )
                }
                return
            }
        }
        _loginState.update { it.copy(isError = true) }
    }
}