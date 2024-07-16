package com.example.demoeni.compose

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demoeni.Movie
import com.example.demoeni.api.MovieService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class MoviesComposeViewModel : ViewModel() {

    var movies = MutableStateFlow(listOf<Movie>())

    fun syncMovie() {
        // Coroutine
        viewModelScope.launch {
            // Chargement en cours
            Log.i("DemoApi", "Appel en cours ...");

            // Récupérer les films dans l'api
            // Et les mettre dans le "movies" qui est Observable
            // Donc ca va notifier les changements à toute les classes qui ecoute ce Observable/Sujet
            movies.value = MovieService.MovieApi.movieService.getMovies();

            Log.i("DemoApi", "Appel terminé !");
        }
    }
}