package com.pat.coroutinesflow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pat.coroutinesflow.Action.ToastButton
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class MainViewModel(val mainState: MainState) : ViewModel() {

    val action = Channel<Action>()

    init {
        viewModelScope.launch {
            action.receiveAsFlow().collect {
                when (it) {
                    ToastButton -> {
                        mainState.showToast.trySend(Unit)
                    }
                }
            }
        }
    }
}

sealed class Action {
    object ToastButton : Action()
}