package com.red.sampleapp.feature.popular

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.red.base.ui.fragment.ViewBindingFragment
import com.red.sampleapp.feature.popular.databinding.FragmentPopularBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PopularFragment : ViewBindingFragment<FragmentPopularBinding>() {
    private val viewModel by viewModels<PopularVM>()
    private lateinit var parentCallback: OnPopularFragmentListener

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btn.setOnClickListener {
            parentCallback.popularBtnClick(this)
            //findNavController().navigate(R.id.action_popularScreen_to_aboutScreenPopular)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            parentCallback = context as OnPopularFragmentListener
        } catch (e: ClassCastException) {
            throw ClassCastException("$context must implement OnHeadlineSelectedListener")
        }
    }
}

interface OnPopularFragmentListener {
    fun popularBtnClick(fragment: PopularFragment)
}