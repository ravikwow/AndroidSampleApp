package com.red.sampleapp.feature.popular

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.red.base.ui.fragment.ViewBindingFragment
import com.red.sampleapp.feature.popular.databinding.FragmentPopularBinding
import com.red.sampleapp.feature.popular.models.MovieUI
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PopularFragment : ViewBindingFragment<FragmentPopularBinding>() {
    private val viewModel by viewModels<PopularVM>()
    private lateinit var parentCallback: OnPopularFragmentListener
    private val onMovieClickListener: (movieUI: MovieUI) -> Unit = { movieUI ->
        parentCallback.popularMovieClick(this, movieUI)
    }
    val adapter = MovieListAdapter(onMovieClickListener)

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

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            parentCallback = context as OnPopularFragmentListener
        } catch (e: ClassCastException) {
            throw ClassCastException("$context must implement OnPopularFragmentListener")
        }
    }
}

interface OnPopularFragmentListener {
    fun popularMovieClick(fragment: PopularFragment, movieUI: MovieUI)
}
