package com.ankitangra.www.dagger_starter.network.auth

import com.ankitangra.www.dagger_starter.models.User
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Path

interface AuthAPI {

    @GET("users/{id}")
    fun getUser (@Path("id") id : Int) : Flowable <User>

}