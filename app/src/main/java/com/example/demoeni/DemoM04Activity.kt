package com.example.demoeni

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DemoM04Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Charger la vue
        setContentView(R.layout.activity_demo_m04)

        // ATTENTION TOUT APRES LE SET CONTENT VIEW
        // Surcharger le comporter du clique (evenementiel)
        // -- Récupérer un composant dans la vue (le bouton)
        val btnOpenActivity = findViewById<View>(R.id.btnOpenActivity);

        // Quand on clique j'ouvre une page
        btnOpenActivity.setOnClickListener {
            // changer d'activité
            val intent = Intent(this, Demo2Activity::class.java);
            startActivity(intent);
        }
    }


}