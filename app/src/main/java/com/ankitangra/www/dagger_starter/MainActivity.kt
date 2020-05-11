package com.ankitangra.www.dagger_starter

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.ankitangra.www.dagger_starter.ui.auth.AuthActivity
import com.ankitangra.www.dagger_starter.ui.auth.AuthViewModel
import com.ankitangra.www.dagger_starter.viewmodels.ViewModelProviderFactory
import com.bumptech.glide.RequestManager
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    private lateinit var authViewModel : AuthViewModel

    @Inject
    lateinit var providerFactory: ViewModelProviderFactory

    @Inject
    lateinit var icon : Drawable

    @Inject
    lateinit var requestManager : RequestManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        authViewModel =  ViewModelProviders.of(this, providerFactory).get(AuthViewModel::class.java)

        setIcon ()

    }

    private fun setIcon () {
        requestManager.load(icon).into(imageView)
    }
}
