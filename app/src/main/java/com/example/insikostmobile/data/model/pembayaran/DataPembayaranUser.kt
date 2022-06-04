package com.example.insikostmobile.data.model.pembayaran


import com.google.gson.annotations.SerializedName

data class DataPembayaranUser(
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
    @SerializedName("updated_at")
    val updatedAt: String
)