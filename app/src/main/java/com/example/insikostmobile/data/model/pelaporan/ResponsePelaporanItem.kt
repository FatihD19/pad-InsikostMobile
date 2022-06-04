package com.example.insikostmobile.data.model.pelaporan


import com.google.gson.annotations.SerializedName

data class ResponsePelaporanItem(
    @SerializedName("content")
    val content: String,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("photo_url")
    val photoUrl: String,
    @SerializedName("updated_at")
    val updatedAt: String,
    @SerializedName("user")
    val dataPelaporanUser: DataPelaporanUser,
    @SerializedName("user_id")
    val userId: String
)