package com.ankitangra.www.dagger_starter.di;

import com.ankitangra.www.dagger_starter.MainActivity;
import com.ankitangra.www.dagger_starter.R;
import com.ankitangra.www.dagger_starter.di.auth.AuthViewModelModule;
import com.ankitangra.www.dagger_starter.ui.auth.AuthViewModel;
import com.bumptech.glide.request.RequestOptions;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector (
            modules = {AuthViewModelModule.class}
    )
    abstract MainActivity contributeAuthActivity();

}
