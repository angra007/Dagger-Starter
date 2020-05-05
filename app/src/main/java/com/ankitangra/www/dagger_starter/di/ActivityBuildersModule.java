package com.ankitangra.www.dagger_starter.di;

import com.ankitangra.www.dagger_starter.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector
    abstract MainActivity contributeAuthActivity();
}
