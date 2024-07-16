package com.example.demoeni.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.demoeni.ui.theme.DemoEniTheme

class DemoComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemoEniTheme {
                DemoComposePage()
            }
        }
    }
}

@Composable
fun DemoComposePage() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()) {
            Text(text = "Chocolatine")
            Text(text = "Beurre Doux")
            OutlinedButton(onClick = {  }, modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)) {
                Text(text = "Submit")
            }
            OutlinedButton(onClick = {  }, modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(imageVector = Icons.Filled.Person, "")
                    Spacer(modifier = Modifier.padding(horizontal = 3.dp))
                    Text(text = "Envoyer")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DemoComposePreview() {
    DemoEniTheme {
        DemoComposePage()
    }
}