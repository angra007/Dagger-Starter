package com.ankitangra.www.dagger_starter.ui.auth;

import android.util.Log;


import javax.inject.Inject;

import androidx.lifecycle.ViewModel;

import com.ankitangra.www.dagger_starter.network.auth.AuthAPI;

public class AuthViewModel extends ViewModel {

    private static final String TAG = "AuthViewModel";

    private final AuthAPI authApi;

    @Inject
    public AuthViewModel(AuthAPI authApi) {
        this.authApi = authApi;
        Log.d(TAG, "AuthViewModel: viewmodel is working...");
    }
}