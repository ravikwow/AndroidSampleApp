package com.red.sampleapp.feature.popular

import android.os.Bundle
import android.view.View
import androidx.core.net.toUri
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import com.red.base.ui.fragment.ViewBindingFragment
import com.red.sampleapp.feature.popular.databinding.FragmentPopularBinding
import com.red.sampleapp.feature.popular.models.MovieUI
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PopularFragment : ViewBindingFragment<FragmentPopularBinding>() {
    private val viewModel by viewModels<PopularVM>()
    private val onMovieClickListener: (movieUI: MovieUI) -> Unit = { movieUI ->
        val request = NavDeepLinkRequest.Builder
            .fromUri("android-app://com.red.sampleapp/aboutmovie/-1/?name=${movieUI.name}".toUri())
            .build()
        findNavController(this).navigate(request)
    }
    private val adapter = MovieListAdapter(onMovieClickListener)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        collectUiState()
    }

    private fun initView() {
        binding.rvMovies.adapter = adapter
    }

    private fun collectUiState() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.getMovies().collectLatest { movies ->
                adapter.submitData(movies)
            }
        }
    }
}
