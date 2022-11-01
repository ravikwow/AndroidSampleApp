package com.red.sampleapp

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.red.base.ui.activity.ViewBindingActivity
import com.red.sampleapp.databinding.ActivityMainBinding
import com.red.sampleapp.feature.aboutmovie.MovieAboutUI
import com.red.sampleapp.feature.random.OnRandomFragmentListener
import com.red.sampleapp.feature.random.RandomFragment
import com.red.sampleapp.feature.random.RandomFragmentDirections
import com.red.sampleapp.feature.saved.OnSavedFragmentListener
import com.red.sampleapp.feature.saved.SavedFragment
import com.red.sampleapp.feature.saved.SavedFragmentDirections
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ViewBindingActivity<ActivityMainBinding>(),
    OnRandomFragmentListener, OnSavedFragmentListener {
    lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_container) as NavHostFragment
        navController = navHostFragment.navController

        binding.bottomNav.setupWithNavController(navController)

        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.randomScreen, R.id.popularScreen, R.id.savedScreen)
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration)
    }

    override fun randomBtnClick(fragment: RandomFragment) {
        val action = RandomFragmentDirections.actionRandomScreenmToAboutScreenRandom(
            MovieAboutUI(
                -1,
                getString(com.red.sampleapp.feature.random.R.string.title_random)
            )
        )
        findNavController(fragment).navigate(action)
    }

    override fun savedBtnClick(fragment: SavedFragment) {
        val action = SavedFragmentDirections.actionSavedScreenToAboutScreenSaved(
            MovieAboutUI(
                -1,
                getString(com.red.sampleapp.feature.saved.R.string.title_saved)
            )
        )
        findNavController(fragment).navigate(action)
    }
}