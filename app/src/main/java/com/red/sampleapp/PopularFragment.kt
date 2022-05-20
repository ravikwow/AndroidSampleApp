package com.red.sampleapp

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.red.base.ui.fragment.ViewBindingFragment
import com.red.sampleapp.databinding.FragmentPopularBinding

class PopularFragment : ViewBindingFragment<FragmentPopularBinding>() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btn.setOnClickListener {
            findNavController().navigate(R.id.action_popularScreen_to_aboutScreenPopular)
        }
    }
}
