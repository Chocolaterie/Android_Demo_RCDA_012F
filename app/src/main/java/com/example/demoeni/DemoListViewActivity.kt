package com.example.demoeni

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.demoeni.databinding.ActivityDemoListViewBinding

class DemoListViewActivity : ComponentActivity() {

    lateinit var viewBinding: ActivityDemoListViewBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Charger la vue en databinding
        viewBinding = DataBindingUtil.setContentView(this, R.layout.activity_demo_list_view);

        /*
        // Liste mock de String
        var products = listOf(
            "Choclatine",
            "Beurre salé",
            "Crevette Nutella"
        );

        // Demo 1 : pas de design custom donc adapter deja developpé
        // -- Specification de l'adapter de la liste (donc la design des cellules)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, products);
        viewBinding.lvDemo.adapter = adapter;
         */

        // Demo 2 : Envoyer les donner dans l'adatper donc alimenter la liste
        val movies = listOf(
            Movie(1, "The thing"),
            Movie(2, "Teletubbies"),
            Movie(3, "Sharknado"),
        );

        val adapter = MovieAdapter(this, movies);

        viewBinding.lvDemo.adapter = adapter;
    }
}