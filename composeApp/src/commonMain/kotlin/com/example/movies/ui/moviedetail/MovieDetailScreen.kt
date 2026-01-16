package com.example.movies.ui.moviedetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.movies.domain.model.Movie
import com.example.movies.domain.model.movie1
import com.example.movies.ui.componenets.CastMemberItem
import com.example.movies.ui.componenets.MovieGenreChip
import com.example.movies.ui.componenets.MovieInfoItem
import com.example.movies.ui.theme.MoviesAppTheme
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.solid.ArrowLeft
import compose.icons.fontawesomeicons.solid.Calendar
import compose.icons.fontawesomeicons.solid.Clock
import compose.icons.fontawesomeicons.solid.Play
import compose.icons.fontawesomeicons.solid.Star
import io.ktor.sse.SPACE
import movies.composeapp.generated.resources.Res
import movies.composeapp.generated.resources.movie
import movies.composeapp.generated.resources.movie_details_button
import movies.composeapp.generated.resources.movie_details_list
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun MovieDetailRoute() {
    MovieDetailScreen(movie = movie1)
}

@Preview(showBackground = true)
@Composable
fun MovieDetailScreenPreview() {
    MoviesAppTheme {
        MovieDetailScreen(movie = movie1)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieDetailScreen(movie: Movie) {
    Scaffold(topBar = {
        CenterAlignedTopAppBar(
            title = { Text(stringResource(Res.string.movie_details_list)) },
            navigationIcon = {
                Surface(
                    modifier = Modifier.padding(start = 16.dp),
                    shape = MaterialTheme.shapes.small
                ) {
                    IconButton(modifier = Modifier.size(32.dp), onClick = {}) {
                        Icon(
                            modifier = Modifier.padding(8.dp),
                            imageVector = FontAwesomeIcons.Solid.ArrowLeft,
                            contentDescription = null
                        )
                    }
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.background)
        )
    }) { paddingValues ->
        Column(modifier = Modifier.fillMaxSize().padding(paddingValues)) {
            Surface(
                modifier = Modifier.fillMaxSize().weight(1f).padding(16.dp),
                shape = MaterialTheme.shapes.large
            ) {
                Image(
                    modifier = Modifier.clip(MaterialTheme.shapes.large),
                    painter = painterResource(Res.drawable.movie),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
            }
            Column(
                modifier = Modifier.fillMaxWidth().weight(2f).padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = movie.title,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.titleLarge
                )

                Spacer(modifier = Modifier.height(8.dp))

                Row(verticalAlignment = Alignment.CenterVertically) {
                    MovieInfoItem(icon = FontAwesomeIcons.Solid.Star, text = "1.5")

                    Spacer(modifier = Modifier.width(16.dp))
                    MovieInfoItem(icon = FontAwesomeIcons.Solid.Clock, text = "2h 36min")

                    Spacer(modifier = Modifier.width(16.dp))
                    MovieInfoItem(icon = FontAwesomeIcons.Solid.Calendar, text = "2022")
                }

                Spacer(modifier = Modifier.height(8.dp))

                Row(verticalAlignment = Alignment.CenterVertically) {
                    MovieGenreChip(genre = "Action")
                }

                Spacer(modifier = Modifier.height(16.dp))

                ElevatedButton(modifier = Modifier.fillMaxWidth(), onClick = {}) {
                    Icon(
                        modifier = Modifier.size(12.dp),
                        imageVector = FontAwesomeIcons.Solid.Play,
                        contentDescription = null
                    )
                    Text(
                        modifier = Modifier.padding(start = 16.dp),
                        text = stringResource(Res.string.movie_details_button),
                        fontWeight = FontWeight.Medium,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                BoxWithConstraints {
                    val itemWidth = this.maxWidth * 0.55f

                    LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                        items(10) {
                            CastMemberItem(
                                modifier = Modifier.width(itemWidth),
                                profilePictureUrl = "",
                                name = "Eddit",
                                character = "Newt",
                            )
                        }
                    }
                }

                Box(modifier = Modifier.padding(vertical = 16.dp)) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Testedsa",
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
        }
    }
}

