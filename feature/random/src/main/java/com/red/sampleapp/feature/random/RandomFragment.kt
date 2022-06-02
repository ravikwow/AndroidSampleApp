package com.red.sampleapp.feature.random

import android.content.Context
import android.os.Bundle
import android.view.View
import com.red.base.ui.fragment.ViewBindingFragment
import com.red.sampleapp.feature.random.databinding.FragmentRandomBinding

class RandomFragment : ViewBindingFragment<FragmentRandomBinding>() {
    private lateinit var parentCallback: OnRandomFragmentListener
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btn.setOnClickListener {
            parentCallback.randomBtnClick(this)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            parentCallback = context as OnRandomFragmentListener
        } catch (e: ClassCastException) {
            throw ClassCastException("$context must implement OnRandomFragmentListener")
        }
    }
}

interface OnRandomFragmentListener {
    fun randomBtnClick(fragment: RandomFragment)
}
