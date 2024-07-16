package com.example.demoeni.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.demoeni.ui.theme.DemoEniTheme

class DemoCounterComposeActivity : ComponentActivity() {

    lateinit var counterComposeViewModel: CounterComposeViewModel;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Instancier le view model
        counterComposeViewModel = CounterComposeViewModel();

        enableEdgeToEdge()
        setContent {
            DemoEniTheme {
                DemoCounterContent(counterComposeViewModel)
            }
        }
    }
}

@Composable
fun DemoCounterContent(counterComposeViewModel: CounterComposeViewModel) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DemoForm(counterComposeViewModel)
            Button(
                onClick = { counterComposeViewModel.count.value += 1 },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Incrementer")
            }
        }
    }
}

@Composable
fun DemoForm(counterComposeViewModel: CounterComposeViewModel){
    // Ecouter les changements de count dans le viewmodel implicitement
    // val count by remember { mutableStateOf(counterComposeViewModel.count.value) };
    val count by counterComposeViewModel.count.collectAsState();

    Column {
        Text(text = "Counter : ${count}")
        TextField(
            value = count.toString(),
            onValueChange = { counterComposeViewModel.count.value = it.toInt() })
    }
}

@Preview(showBackground = true)
@Composable
fun DemoCounterComposeActivityPreview() {
    DemoEniTheme {
        DemoCounterContent(CounterComposeViewModel())
    }
}