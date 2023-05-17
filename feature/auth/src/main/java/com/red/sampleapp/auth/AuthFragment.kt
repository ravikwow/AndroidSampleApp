package com.red.sampleapp.auth

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.viewModelScope
import com.red.base.ui.fragment.ViewBindingFragment
import com.red.sampleapp.auth.databinding.FragmentAuthBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AuthFragment : ViewBindingFragment<FragmentAuthBinding>() {
    private val vm by viewModels<AuthVM>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnDone.setOnClickListener {
            vm.viewModelScope.launch {
                vm.auth(binding.etApiKey.text.toString())
            }
        }
    }
}