package com.example.demoeni.api

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.demoeni.R
import kotlinx.coroutines.launch

class DemoAPIActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_demo_apiactivity)

        // Demo appel API
        // -- appel d'une coroutine (une tâche asynchrone sécurisé)
        lifecycleScope.launch {

            // -- appel l'api
            val movies = MovieService.MovieApi.movieService.getMovies();

            // -- logger le resultat
            for (movie in movies){
                Log.i("DemoAPI", "Movie Id : ${movie.id} - Title : ${movie.title}");
            }
        }
    }
}