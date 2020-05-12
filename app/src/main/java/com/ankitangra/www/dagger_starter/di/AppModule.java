package com.ankitangra.www.dagger_starter.di;

import android.app.Application;
import android.graphics.drawable.Drawable;

import androidx.core.content.ContextCompat;

import com.ankitangra.www.dagger_starter.R;
import com.ankitangra.www.dagger_starter.utils.Constants;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * This Module will contain all those dependencies which would be available through the lifetime of the application
 * Basically all the Singletons
 */
@Module
public class AppModule {

    @Singleton
    @Provides
    static Retrofit providesRetrofitInstance () {
        return new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }


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
