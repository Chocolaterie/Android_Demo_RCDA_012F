package com.example.demoeni.compose

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class CounterComposeViewModel : ViewModel() {

    var count = MutableStateFlow(0);
}