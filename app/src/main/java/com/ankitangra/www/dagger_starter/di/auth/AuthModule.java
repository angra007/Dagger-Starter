package com.ankitangra.www.dagger_starter.di.auth;

import com.ankitangra.www.dagger_starter.network.auth.AuthAPI;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class AuthModule {

    @Provides
    static AuthAPI providesAuthAPI(Retrofit retrofit) {
        return retrofit.create(AuthAPI.class);
    }

}
