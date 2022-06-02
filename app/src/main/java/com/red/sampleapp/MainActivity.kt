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
import com.red.sampleapp.feature.popular.OnPopularFragmentListener
import com.red.sampleapp.feature.popular.PopularFragment
import com.red.sampleapp.feature.random.OnRandomFragmentListener
import com.red.sampleapp.feature.random.RandomFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ViewBindingActivity<ActivityMainBinding>(), OnPopularFragmentListener, OnRandomFragmentListener {
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

    override fun popularBtnClick(fragment: PopularFragment) {
        findNavController(fragment).navigate(R.id.action_popularScreen_to_aboutScreenPopular)
    }

    override fun randomBtnClick(fragment: RandomFragment) {
        findNavController(fragment).navigate(R.id.action_randomScreenm_to_aboutScreenRandom)
    }
}