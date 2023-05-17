package com.red.sampleapp.auth

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import androidx.core.net.toUri
import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.fragment.NavHostFragment
import com.red.base.ui.fragment.ViewBindingFragment
import com.red.sampleapp.auth.databinding.FragmentAuthBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AuthFragment : ViewBindingFragment<FragmentAuthBinding>() {
    private val vm by viewModels<AuthVM>()
    private val onFinishListener: () -> Unit = {
        val request = NavDeepLinkRequest.Builder
            .fromUri("android-app://com.red.sampleapp/random".toUri())
            .build()
        NavHostFragment.findNavController(this).popBackStack(R.id.auth, true);
        NavHostFragment.findNavController(this).navigate(request)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewLifecycleOwner.lifecycleScope.launch {
            vm.uiState
                .flowWithLifecycle(viewLifecycleOwner.lifecycle)
                .collect { uiState ->
                    when (uiState.authState) {
                        AuthState.IDLE -> {
                            showLoading(false)
                        }
                        AuthState.LOGGED -> {
                            onFinishListener.invoke()
                        }
                        AuthState.LOADING -> {
                            showLoading(true)
                        }
                        AuthState.ERROR -> {
                            showError(uiState.error)
                        }
                    }
                }
        }
        binding.btnDone.setOnClickListener {
            vm.viewModelScope.launch {
                vm.auth(binding.etApiKey.text.toString())
            }
        }
    }

    private fun showError(error: String) {
        AlertDialog.Builder(context)
            .setMessage(error)
            .setPositiveButton(android.R.string.ok, null)
            .create().show()
    }

    private fun showLoading(loading: Boolean) {
    }
}