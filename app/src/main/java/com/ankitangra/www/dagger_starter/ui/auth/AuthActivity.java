package com.ankitangra.www.dagger_starter.ui.auth;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import dagger.android.support.DaggerAppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.ankitangra.www.dagger_starter.R;
import com.ankitangra.www.dagger_starter.models.User;
import com.ankitangra.www.dagger_starter.viewmodels.ViewModelProviderFactory;
import com.bumptech.glide.RequestManager;


import javax.inject.Inject;

public class AuthActivity extends DaggerAppCompatActivity {

    private static final String TAG = "AuthActivity";

    private AuthViewModel viewModel;
    private EditText userId;
    private ProgressBar progressBar;

    @Inject
    ViewModelProviderFactory providerFactory;

    @Inject
    Drawable logo;

    @Inject
    RequestManager requestManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.progressBar);

        viewModel = ViewModelProviders.of(this, providerFactory).get(AuthViewModel.class);
        subscribeObservers();
        attemptLogin();
    }

    private void showProgressBar ( Boolean isVisible) {
        if (isVisible) {
            progressBar.setVisibility(View.VISIBLE);
        }
        else  {
            progressBar.setVisibility(View.GONE);
        }
    }

    private void subscribeObservers(){
        viewModel.observeUser().observe(this, new Observer<AuthResource<User>>() {
            @Override
            public void onChanged(AuthResource<User> authResource) {
                if(authResource != null){

                    switch (authResource.status) {
                        case LOADING:{
                            showProgressBar (true);
                            break;
                        }

                        case AUTHENTICATED: {
                            showProgressBar (false);
                            Log.d(TAG,"Login Success");
                            break;
                        }

                        case NOT_AUTHENTICATED: {
                            showProgressBar (false);
                            Log.d(TAG,"Not Authenticated");
                            break;
                        }

                        case ERROR:{
                            showProgressBar (false);
                            Log.d(TAG,"Error");
                            break;
                        }
                    }

                }
            }
        });
    }


    private void attemptLogin(){

        viewModel.authenticateWithId(1);
    }

}
