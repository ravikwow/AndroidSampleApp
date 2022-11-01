package com.red.sampleapp.feature.aboutmovie

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.navArgs
import com.red.base.ui.fragment.ViewBindingFragment
import com.red.sampleapp.feature.aboutmovie.databinding.FragmentAboutBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AboutFragment : ViewBindingFragment<FragmentAboutBinding>() {
    private val args: AboutFragmentArgs by navArgs()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //binding.tvMovieName.text = args.name ?: getString(R.string.empty_arguments)
        binding.tvMovieName.text = args.name
        val id = args.id
    }
}
