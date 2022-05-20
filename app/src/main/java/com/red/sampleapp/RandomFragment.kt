package com.red.sampleapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.red.base.ui.fragment.ViewBindingFragment
import com.red.sampleapp.databinding.FragmentRandomBinding

class RandomFragment : ViewBindingFragment<FragmentRandomBinding>() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btn.setOnClickListener {
            findNavController().navigate(R.id.action_randomScreenm_to_aboutScreenRandom)
        }
    }
}
