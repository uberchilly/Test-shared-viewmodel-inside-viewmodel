package com.nexoslav.testsharedviewmodelinsideviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navController = Navigation.findNavController(findViewById(R.id.nav_host_fragment))
    }

    override fun onBackPressed() {
        if (onBackPressedDispatcher.hasEnabledCallbacks() || !navController.navigateUp()) {
            super.onBackPressed()
        }
    }
}