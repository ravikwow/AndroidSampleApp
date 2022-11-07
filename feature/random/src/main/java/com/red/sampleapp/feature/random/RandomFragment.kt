package com.red.sampleapp.feature.random

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.net.toUri
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.navOptions
import com.red.base.ui.fragment.ViewBindingFragment
import com.red.sampleapp.feature.random.databinding.FragmentRandomBinding

class RandomFragment : ViewBindingFragment<FragmentRandomBinding>() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btn.setOnClickListener {
            setFragmentResultListener("AboutFragment") { key, bundle ->
                val id = bundle.getInt("id")
                val name = bundle.getString("name")
                Toast.makeText(context, "id: $id, name: $name", Toast.LENGTH_SHORT).show()
            }
            val id = -1
            val name = getString(R.string.title_random)
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
