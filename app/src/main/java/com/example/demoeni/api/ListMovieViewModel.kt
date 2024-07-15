package com.example.demoeni.api

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demoeni.Movie
import kotlinx.coroutines.launch

class ListMovieViewModel : ViewModel() {

    var movies = MutableLiveData<List<Movie>>();

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