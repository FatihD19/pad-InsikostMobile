package com.example.insikostmobile.data.network

import com.example.insikostmobile.data.model.berita.ResponseNewsItem
import com.example.insikostmobile.data.model.login.ResponeLogin
import com.example.insikostmobile.data.model.pelaporan.ResponsePelaporanItem
import com.example.insikostmobile.data.model.pembayaran.ResponsePayments
import com.example.insikostmobile.data.model.pembayaran.ResponsePembayaranItem
import io.reactivex.Single
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiEndpoint {
    /**
     * Login Api
     */
    @FormUrlEncoded
    @POST("users/login")
    fun login(
        @Field("phone") phone: String,
        @Field("password") password: String
    ) : Single<ResponeLogin>

    @GET("payments")
    fun payments(
    ) : Single<List<ResponsePembayaranItem>>

    @GET("news")
    fun news(
    ) : Single<List<ResponseNewsItem>>

    @GET("complaints")
    fun complaints(
    ) : Single<List<ResponsePelaporanItem>>

    @FormUrlEncoded
    @POST("payments")
    fun createPayment(
        @Field("id_user") id_user:String,
        @Field("room_id") room_id:String,
        @Field("month") month: String,
        @Field("year") year:String,
        @Field("nominal") nominal: String,
        @Field("uang_diterima") uang_diterima: String,
        @Field("photo_url") photo_url:String,

        ) : Single<ResponsePayments>
}