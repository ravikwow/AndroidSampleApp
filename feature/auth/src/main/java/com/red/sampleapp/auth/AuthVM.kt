package com.red.sampleapp.auth

import androidx.lifecycle.ViewModel
import com.red.sampleapp.auth.domain.AuthUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class AuthVM @Inject constructor(
    private val authUseCase: AuthUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(AuthUIState())
    val uiState: StateFlow<AuthUIState> = _uiState.asStateFlow()

    suspend fun auth(apiKey: String) {
        _uiState.value = AuthUIState(AuthState.LOADING)
        try {
            authUseCase.execute(apiKey)
            _uiState.value = AuthUIState(AuthState.LOGGED)
        } catch (throwable: Throwable) {
            _uiState.value = AuthUIState(AuthState.ERROR, throwable.localizedMessage ?: "")
        }
        _uiState.value = AuthUIState(AuthState.IDLE)
    }
}