package com.example.demoeni.api

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.demoeni.Movie
import com.example.demoeni.MovieAdapter
import com.example.demoeni.R
import com.example.demoeni.databinding.ActivityDemoApiListViewBinding
import com.example.demoeni.databinding.ActivityDemoListViewBinding

class DemoApiListViewActivity : ComponentActivity() {

    lateinit var viewBinding: ActivityDemoApiListViewBinding;
    lateinit var listMoveViewModel: ListMovieViewModel;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Charger
        viewBinding = DataBindingUtil.setContentView(this, R.layout.activity_demo_api_list_view);

        // Instancier un view model
        listMoveViewModel = ListMovieViewModel();

        // Quand clique sur le bouton => appel API
        viewBinding.btnCallApi.setOnClickListener {
            Log.i("DemoApi", "Avant d'appeler");
            // je vide la liste avant d'appel le web service
            viewBinding.lvMovie.adapter = MovieAdapter(this, listOf<Movie>());
            // appeler le viewmodel
            listMoveViewModel.syncMovie();
        }

        // Ecouter quand movies change
        listMoveViewModel.movies.observe(this, Observer {
            Log.i("DemoApi", "J'ai detecté que la List<Movie> a changé dans le viewmodel");

            // Rafraichir la list view
            val adapter = MovieAdapter(this, listMoveViewModel.movies.value!!);
            viewBinding.lvMovie.adapter = adapter;
        })
    }
}