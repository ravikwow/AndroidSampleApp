package com.red.sampleapp.auth

data class AuthUIState(
    val authState: AuthState = AuthState.IDLE,
    val error: String = ""
)

enum class AuthState {
    IDLE, LOGGED, ERROR, LOADING
}