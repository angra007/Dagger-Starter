package com.ankitangra.www.dagger_starter.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class User (
    @SerializedName("id")
    @Expose
    val id : String = "-1",

    @SerializedName("username")
    @Expose
    val userName : String? = null,

    @SerializedName("email")
    @Expose
    val email : String? = null,

    @SerializedName("website")
    @Expose
    val website : String? = null) {

}