package com.example.insikostmobile.data.model.login


import com.google.gson.annotations.SerializedName

data class DataRoom(
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("facilities")
    val dataFacilities: List<DataFacility>,
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("photo_url")
    val photoUrl: String,
    @SerializedName("price")
    val price: Int,
    @SerializedName("size")
    val size: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("updated_at")
    val updatedAt: String,
    @SerializedName("user_id")
    val userId: String
)