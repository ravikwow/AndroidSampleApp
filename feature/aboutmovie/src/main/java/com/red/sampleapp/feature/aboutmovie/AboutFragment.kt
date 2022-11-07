package com.red.sampleapp.feature.aboutmovie

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.red.base.ui.fragment.ViewBindingFragment
import com.red.sampleapp.feature.aboutmovie.databinding.FragmentAboutBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AboutFragment : ViewBindingFragment<FragmentAboutBinding>() {
    private var movieName: String = ""
    private var movieId: Int = -1
    private val args: AboutFragmentArgs by navArgs()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //binding.tvMovieName.text = args.name ?: getString(R.string.empty_arguments)
        movieName = args.name
        movieId = args.id
        binding.tvMovieName.text = movieName
        binding.btnReturnResult.setOnClickListener {
            setFragmentResult("AboutFragment", bundleOf("name" to movieName, "id" to movieId))
            findNavController().navigateUp()
        }
    }
}
