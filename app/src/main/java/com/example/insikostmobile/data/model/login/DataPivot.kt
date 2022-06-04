package com.example.insikostmobile.data.model.login


import com.google.gson.annotations.SerializedName

data class DataPivot(
    @SerializedName("facility_id")
    val facilityId: String,
    @SerializedName("room_id")
    val roomId: String
)