package com.ankitangra.www.dagger_starter.di;

import androidx.lifecycle.ViewModelProvider;

import com.ankitangra.www.dagger_starter.viewmodels.ViewModelProviderFactory;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class ViewModelFactoryModule {

    @Binds
    public abstract ViewModelProvider.Factory bindViewModelFactory (ViewModelProviderFactory modelProviderFactory);
}
