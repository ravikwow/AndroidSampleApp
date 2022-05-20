package com.red.base.ui.activity

import android.os.Bundle
import android.util.Log
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity


open class LogLifeCycleActivity : AppCompatActivity() {
    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        logLifeCycle("onCreate")
    }

    override fun onRestart() {
        super.onRestart()
        logLifeCycle("onRestart")
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

    override fun onDestroy() {
        super.onDestroy()
        logLifeCycle("onDestroy")
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
        Log.d("ActivitiesLifeCycle", getLogTag() + ": " + text)
    }
}