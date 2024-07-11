package com.example.demoeni

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity

class DemoM07Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_demo_m07);

        // Quand je clique sur le bouton
        val btnSubmit = findViewById<Button>(R.id.btnSubmit);
        btnSubmit.setOnClickListener {

            // Afficher la saisie dans un log
            // 1 -- récupérer l'edit text le champ
            val edtTest = findViewById<EditText>(R.id.edtFieldTest);
            // 2 -- récupérer la valeur du champ
            val valueTest = edtTest.text.toString();
            // 3 -- afficher le log
            Log.i("Demo04", "La valeur saisie : ${valueTest}");

            //  Afficher une popup
            val builder = AlertDialog.Builder(this);
            // -- titre de la popup
            builder.setTitle("Information");
            // -- message dans la popup
            builder.setMessage("La valeur saisie : ${valueTest}");
            // -- afficher dans l'écran
            builder.show();

        }
    }
}