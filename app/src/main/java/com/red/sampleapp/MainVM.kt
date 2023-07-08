package com.red.sampleapp

import androidx.core.net.toUri
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.NavDeepLinkRequest
import com.red.sampleapp.domain.ApiKeyUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class MainVM @Inject constructor(
    private val apiKeyUseCase: ApiKeyUseCase
) : ViewModel() {
    fun startFragment(navController: NavController) {
        val isValidKey = runBlocking { apiKeyUseCase.checkApiKey() }
        val inflater = navController.navInflater
        val graph = inflater.inflate(R.navigation.nav_graph)
        if (isValidKey) {
            graph.setStartDestination(com.red.sampleapp.feature.random.R.id.random)
        } else {
            graph.setStartDestination(com.red.sampleapp.auth.R.id.auth)
        }
        navController.setGraph(graph, null)
    }

    fun logout(navController: NavController) {
        CoroutineScope(Dispatchers.IO).launch {
            apiKeyUseCase.removeApiKey()
        }
        val request = NavDeepLinkRequest.Builder
            .fromUri("android-app://com.red.sampleapp/auth".toUri())
            .build()
        navController.currentDestination?.id?.let { navController.popBackStack(it, true) };
        navController.navigate(request)
    }
}