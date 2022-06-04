package com.example.insikostmobile.data.model.berita


import com.google.gson.annotations.SerializedName

data class ResponseNewsItem(
    @SerializedName("content")
    val content: String,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("last_sent")
    val lastSent: String,
    @SerializedName("updated_at")
    val updatedAt: String
)