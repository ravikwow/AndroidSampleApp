package com.red.base.ui.activity

import android.os.Bundle
import android.view.LayoutInflater
import androidx.viewbinding.ViewBinding
import java.lang.reflect.ParameterizedType

open class ViewBindingActivity<T : ViewBinding> : LogLifeCycleActivity() {
    protected lateinit var binding: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            val persistentClass = (javaClass.genericSuperclass as ParameterizedType)
                .actualTypeArguments[0] as Class<*>
            val method = persistentClass.getMethod("inflate", LayoutInflater::class.java)
            @Suppress("UNCHECKED_CAST")
            binding = method.invoke(null, layoutInflater) as T
            setContentView(binding.root)
        } catch (throwable: Throwable) {
            throwable.printStackTrace()
        }
    }
}