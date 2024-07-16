package com.example.demoeni.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.demoeni.Movie
import com.example.demoeni.ui.theme.DemoEniTheme

class DemoListComposeActivity : ComponentActivity() {

    lateinit var moviesComposeViewModel: MoviesComposeViewModel;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        moviesComposeViewModel = MoviesComposeViewModel()

        enableEdgeToEdge()
        setContent {
            DemoEniTheme {
                ListPage(moviesComposeViewModel)
            }
        }

        // Appeler l'api
        moviesComposeViewModel.syncMovie();
    }
}

@Composable
fun ListPage(moviesComposeViewModel: MoviesComposeViewModel){
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MovieListView(moviesComposeViewModel)
        }
    }
}

@Composable
fun MovieListView(moviesComposeViewModel: MoviesComposeViewModel){
    val movies by moviesComposeViewModel.movies.collectAsState();

    LazyColumn {
        items(movies) { movie ->
            Text(text = movie.title)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DemoListComposeActivityPreview() {
    DemoEniTheme {
        ListPage(MoviesComposeViewModel())
    }
}