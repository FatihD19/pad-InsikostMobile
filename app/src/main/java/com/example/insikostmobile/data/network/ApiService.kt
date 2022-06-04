package com.example.insikostmobile.data.network

import com.example.insikostmobile.data.db.Sessions
import com.example.insikostmobile.data.model.berita.ResponseNewsItem
import com.example.insikostmobile.data.model.login.ResponeLogin
import com.example.insikostmobile.data.model.pelaporan.ResponsePelaporanItem
import com.example.insikostmobile.data.model.pembayaran.ResponsePayments
import com.example.insikostmobile.data.model.pembayaran.ResponsePembayaranItem
import com.example.insikostmobile.root.App
import io.reactivex.Single
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiService {
    private val api: ApiEndpoint

    init {
        val client = OkHttpClient().newBuilder()
//            .addInterceptor(HttpLoggingInterceptor().apply {
//                level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else
//                    HttpLoggingInterceptor.Level.NONE
//            })
            .addInterceptor(Interceptor { chain ->
                val builder = chain.request().newBuilder()
                if (App.sessions!!.getString(Sessions.Authorization) != "") {
                    builder.header(
                        "Authorization",
                        "Bearer " + App.sessions!!.getString(Sessions.Authorization)
                    )
                }
                return@Interceptor chain.proceed(builder.build())
            })

            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()


        val server = "http://192.168.1.4:8000/api/"
        api = Retrofit.Builder()
            .baseUrl(server)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
            .build()
            .create(ApiEndpoint::class.java)
    }

    fun postLogin(phone: String,password:String): Single<ResponeLogin> {
        return api.login(phone, password)
    }
    fun getListPayments():Single<List<ResponsePembayaranItem>>{
        return api.payments()
    }
    fun getListNews():Single<List<ResponseNewsItem>>{
        return api.news()
    }
    fun getListComplaints():Single<List<ResponsePelaporanItem>>{
        return api.complaints()
    }
    fun postListPayments(
        room_id:String,
        id_user:String,
        nominal: String,
        month: String,
        year:String,
        uang_diterima:String,
        photo_url:String
    ):Single<ResponsePayments>{
        return api.createPayment(room_id,id_user,nominal,month,year,uang_diterima,photo_url)
    }
}