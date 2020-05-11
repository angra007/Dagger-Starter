package com.ankitangra.www.dagger_starter.di.auth;

import androidx.lifecycle.ViewModel;

import com.ankitangra.www.dagger_starter.di.ViewModelKey;
import com.ankitangra.www.dagger_starter.ui.auth.AuthViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class AuthViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(AuthViewModel.class)
    public abstract ViewModel bindViewModel (AuthViewModel viewModel);

}
