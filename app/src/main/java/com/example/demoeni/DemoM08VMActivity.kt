package com.example.demoeni

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.demoeni.databinding.ActivityDemoM08VmactivityBinding
import com.example.demoeni.viewmodel.CounterViewModel

class DemoM08VMActivity : ComponentActivity() {

    lateinit var viewBinding : ActivityDemoM08VmactivityBinding;
    lateinit var counterViewModel: CounterViewModel;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);

        // Pas en databinding (En databinding il ne faut pas le faire)
        // setContentView(R.layout.activity_demo_m08_vmactivity);

        // En databinding
        viewBinding = DataBindingUtil.setContentView(this, R.layout.activity_demo_m08_vmactivity);

        // Afficher dans le log le text du TextView tvAberration
        // Log.i("Demo", viewBinding.tvAberration.text.toString());

        // Associer le viewmodel dans le xml
        counterViewModel = CounterViewModel();
        viewBinding.counterViewModel = counterViewModel;

        // Ecouter quand le compteur change dans la mémoire
        counterViewModel.counter.observe(this, Observer {
            // Rafraichir l'ecran
            viewBinding.counterViewModel = counterViewModel;
        })
    }
}