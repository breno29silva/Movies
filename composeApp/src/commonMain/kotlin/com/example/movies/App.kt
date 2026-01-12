package com.example.movies

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.movies.di.dataModule
import com.example.movies.di.networkModule
import com.example.movies.di.viewModelModule
import com.example.movies.navigation.AppRoutes
import com.example.movies.ui.movies.MoviesListRoute
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplication

@Composable
@Preview
fun App() {
    KoinApplication(application = { modules(networkModule, dataModule, viewModelModule) }) {
        MaterialTheme {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = AppRoutes.MoviesList) {
                composable<AppRoutes.MoviesList> {
                    MoviesListRoute()
                }

                composable<AppRoutes.MovieDetails> {
                    //MovieDetailsScreen
                }
            }
        }
    }
}