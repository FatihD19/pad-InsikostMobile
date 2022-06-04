package com.example.insikostmobile.data.model.login


import com.google.gson.annotations.SerializedName

data class DataUser(
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("photo_url")
    val photoUrl: String,
    @SerializedName("role")
    val role: String,
    @SerializedName("room")
    val dataRoom: DataRoom,
    @SerializedName("updated_at")
    val updatedAt: String
)