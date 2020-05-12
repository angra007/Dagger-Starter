package com.ankitangra.www.dagger_starter.network.auth

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET

interface AuthAPI {

    @GET
    fun getFake() : Call<ResponseBody>
}