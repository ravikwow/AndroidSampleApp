package com.red.sampleapp.auth

import androidx.lifecycle.ViewModel
import com.red.sampleapp.auth.domain.AuthUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthVM @Inject constructor(
    private val authUseCase: AuthUseCase
) : ViewModel() {
    suspend fun auth(apiKey: String) {
        CoroutineScope(Dispatchers.IO).launch {
            authUseCase.execute(apiKey)
        }
    }
}