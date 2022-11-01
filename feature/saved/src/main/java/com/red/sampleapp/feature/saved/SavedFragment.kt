package com.red.sampleapp.feature.saved

import android.os.Bundle
import android.view.View
import androidx.core.net.toUri
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.navOptions
import com.red.base.ui.fragment.ViewBindingFragment
import com.red.sampleapp.feature.saved.databinding.FragmentSavedBinding

class SavedFragment : ViewBindingFragment<FragmentSavedBinding>() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btn.setOnClickListener {
            val id = -1
            val name = getString(R.string.title_saved)
            val request = NavDeepLinkRequest.Builder
                .fromUri("android-app://com.red.sampleapp/aboutmovie/${id}/?name=${name}".toUri())
                .build()
            NavHostFragment.findNavController(this).navigate(request, navOptions {
                anim {
                    enter = android.R.anim.fade_in
                    exit = android.R.anim.fade_out
                    popEnter = android.R.anim.fade_in
                    popExit = android.R.anim.fade_out
                }
            })
        }
    }
}
