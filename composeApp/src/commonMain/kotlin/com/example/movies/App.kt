package com.example.movies

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.movies.navigation.AppRoutes
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = AppRoutes.MoviesList) {
            composable<AppRoutes.MoviesList> {
                //MoviesListScreen
            }

            composable<AppRoutes.MovieDetails> {
                //MovieDetailsScreen
            }
        }
    }
}