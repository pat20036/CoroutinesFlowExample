package com.pat.coroutinesflow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    val channel = Channel<Int>()

    init {
        viewModelScope.launch {

        }
    }
}