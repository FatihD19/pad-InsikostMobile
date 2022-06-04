package com.example.insikostmobile.data.model.login


import com.google.gson.annotations.SerializedName

data class DataFacility(
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("pivot")
    val dataPivot: DataPivot,
    @SerializedName("updated_at")
    val updatedAt: String
)