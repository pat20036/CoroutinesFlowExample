package com.pat.coroutinesflow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.pat.coroutinesflow.MainViewModel.Action.ClickButton
import com.pat.coroutinesflow.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import org.koin.android.viewmodel.ext.android.viewModel
import reactivecircus.flowbinding.android.view.clicks

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycleScope.launch { subscribeUI() }

    }

    private fun subscribeUI()
    {

         binding.button.clicks().map {
             ClickButton
         }.onEach { viewModel.action.trySend(it) }
            .launchIn(lifecycleScope)
    }
}