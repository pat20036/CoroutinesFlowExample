package com.pat.coroutinesflow

import kotlinx.coroutines.channels.Channel

class MainState {
    val showToast = Channel<Unit>()
}