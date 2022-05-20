package com.red.base.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import java.lang.reflect.ParameterizedType

open class ViewBindingFragment<T : ViewBinding> : LogLifeCycleFragment() {
    protected lateinit var binding: T

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return try {
            val persistentClass = (javaClass.genericSuperclass as ParameterizedType)
                .actualTypeArguments[0] as Class<*>
            val method = persistentClass.getMethod("inflate", LayoutInflater::class.java)
            @Suppress("UNCHECKED_CAST")
            binding = method.invoke(null, layoutInflater) as T
            binding.root
        } catch (throwable: Throwable) {
            throwable.printStackTrace()
            super.onCreateView(inflater, container, savedInstanceState)
        }
    }
}