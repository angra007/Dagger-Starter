package com.ankitangra.www.dagger_starter.di;

import android.app.Application;
import android.content.Context;
import android.graphics.drawable.Drawable;

import androidx.core.content.ContextCompat;

import com.ankitangra.www.dagger_starter.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Singleton
    @Provides
    static RequestOptions provideRequestOptions() {
        return RequestOptions.placeholderOf(R.drawable.ic_continue_watching_selected);
    }

    @Singleton
    @Provides
    static RequestManager provideGlideInstance (Application application, RequestOptions requestOptions) {
        return Glide.with(application)
                .setDefaultRequestOptions(requestOptions);
    }

    @Singleton
    @Provides
    static Drawable provideAppDrawable (Application application) {
        return ContextCompat.getDrawable(application, R.drawable.ic_continue_watching_selected);
    }
}
