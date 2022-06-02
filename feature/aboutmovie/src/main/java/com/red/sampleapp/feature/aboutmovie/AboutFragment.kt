package com.red.sampleapp.feature.aboutmovie

import android.os.Bundle
import android.view.View
import com.red.base.ui.fragment.ViewBindingFragment
import com.red.sampleapp.feature.aboutmovie.databinding.FragmentAboutBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AboutFragment : ViewBindingFragment<FragmentAboutBinding>() {
    private var movieAboutUI: MovieAboutUI? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        movieAboutUI = arguments?.getParcelable("movie")
        binding.tvMovieName.text = movieAboutUI?.name ?: getString(R.string.empty_arguments)
    }
}
