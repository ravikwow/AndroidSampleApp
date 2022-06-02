package com.red.sampleapp.feature.saved

import android.content.Context
import android.os.Bundle
import android.view.View
import com.red.base.ui.fragment.ViewBindingFragment
import com.red.sampleapp.feature.saved.databinding.FragmentSavedBinding

class SavedFragment : ViewBindingFragment<FragmentSavedBinding>() {
    private lateinit var parentCallback: OnSavedFragmentListener
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btn.setOnClickListener {
            parentCallback.savedBtnClick(this)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            parentCallback = context as OnSavedFragmentListener
        } catch (e: ClassCastException) {
            throw ClassCastException("$context must implement OnSavedFragmentListener")
        }
    }
}

interface OnSavedFragmentListener {
    fun savedBtnClick(fragment: SavedFragment)
}
