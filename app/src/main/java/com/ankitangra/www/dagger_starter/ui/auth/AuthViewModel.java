package com.ankitangra.www.dagger_starter.ui.auth;

import android.util.Log;


import javax.inject.Inject;

import androidx.lifecycle.ViewModel;

import com.ankitangra.www.dagger_starter.models.User;
import com.ankitangra.www.dagger_starter.network.auth.AuthAPI;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class AuthViewModel extends ViewModel {

    private static final String TAG = "AuthViewModel";

    private final AuthAPI authApi;

    @Inject
    public AuthViewModel(AuthAPI authApi) {
        this.authApi = authApi;

        authApi.getUser(1)
                .toObservable()
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<User>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(User user) {
                        Log.d(TAG, "AuthViewModel: OnNext is working...");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "AuthViewModel: OnError is working..." + e.getLocalizedMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "AuthViewModel: OnComplete is working...");
                    }
                });
        Log.d(TAG, "AuthViewModel: viewmodel is working...");
    }
}