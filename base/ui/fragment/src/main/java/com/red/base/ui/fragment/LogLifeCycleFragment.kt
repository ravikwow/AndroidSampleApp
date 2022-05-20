package com.red.base.ui.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment


open class LogLifeCycleFragment : Fragment() {
    override fun onAttach(context: Context) {
        super.onAttach(context)
        logLifeCycle("onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        logLifeCycle("onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)
        logLifeCycle("onCreateView")
        return view
    }

    override fun onStart() {
        super.onStart()
        logLifeCycle("onStart")
    }

    override fun onResume() {
        super.onResume()
        logLifeCycle("onResume")
    }

    override fun onPause() {
        super.onPause()
        logLifeCycle("onPause")
    }

    override fun onStop() {
        super.onStop()
        logLifeCycle("onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        logLifeCycle("onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        logLifeCycle("onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        logLifeCycle("onDetach")
    }

    fun getLogTag(): String {
        val enclosingClass = javaClass.enclosingClass
        return if (enclosingClass != null) {
            enclosingClass.simpleName
        } else {
            javaClass.simpleName
        }
    }

    protected fun logLifeCycle(text: String) {
        Log.d("FragmentsLifeCycle", getLogTag() + ": " + text)
    }
}