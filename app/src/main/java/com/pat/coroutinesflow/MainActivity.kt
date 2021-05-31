package com.pat.coroutinesflow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.pat.coroutinesflow.Action.ToastButton
import com.pat.coroutinesflow.databinding.ActivityMainBinding
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
    }

    override fun onStart() {
        super.onStart()

        lifecycleScope.launch {
            viewModel.mainState.showToast.receiveAsFlow().collect {
                Toast.makeText(applicationContext, "Toast!", Toast.LENGTH_SHORT).show()
            }
        }

        subscribeUI()
    }

    private fun subscribeUI() {
        binding.toastButton.clicks().map {
            viewModel.action.trySend(ToastButton)
        }.launchIn(lifecycleScope)
    }
}