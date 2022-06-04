package com.example.insikostmobile.data.model.login


import com.google.gson.annotations.SerializedName

data class ResponeLogin(
    @SerializedName("access_token")
    val accessToken: String,
    @SerializedName("expires_in")
    val expiresIn: String,
    @SerializedName("token_type")
    val tokenType: String,
    @SerializedName("user")
    val dataUser: DataUser
)