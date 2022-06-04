package com.example.insikostmobile.data.model.pembayaran


import com.google.gson.annotations.SerializedName

data class ResponsePembayaranItem(
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("month")
    val month: String,
    @SerializedName("nominal")
    val nominal: Int,
    @SerializedName("photo_url")
    val photoUrl: String,

    @SerializedName("room")
    val dataPembayaranRoom: DataPembayaranRoom,

    @SerializedName("room_id")
    val roomId: String,
    @SerializedName("status")
    val status: String? = null,
    @SerializedName("uang_diterima")
    val uangDiterima: Int,
    @SerializedName("uang_kembalian")
    val uangKembalian: Int? = null,
    @SerializedName("updated_at")
    val updatedAt: String,

    @SerializedName("user")
    val dataPembayaranUser: DataPembayaranUser,

    @SerializedName("user_id")
    val userId: String,
    @SerializedName("year")
    val year: String
)