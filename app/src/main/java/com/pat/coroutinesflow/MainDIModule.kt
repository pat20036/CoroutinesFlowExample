package com.pat.coroutinesflow

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainModule = module {
    single<MainState> { MainState() }
    viewModel { MainViewModel(get()) }
}