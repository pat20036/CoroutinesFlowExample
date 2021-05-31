package com.pat.coroutinesflow

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pat.coroutinesflow.MainViewModel.Action.ClickButton
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    val action = Channel<Action>()

    init {
        viewModelScope.launch {
            action.receiveAsFlow().collect {
                when(it)
                {
                    ClickButton -> {
                        Log.d("www", "dziala")
                    }
                }
            }
        }
    }


    sealed class Action {
        object ClickButton : Action()
    }
}
