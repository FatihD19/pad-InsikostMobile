package com.example.insikostmobile.data.db

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import com.example.insikostmobile.BuildConfig


@SuppressLint("CommitPrefEdits")
class Sessions(context : Context) {
    companion object {
        var sessions: Sessions?= null
        var PREF_NAME = BuildConfig.APPLICATION_ID+".session"

        val id_user : String = "id_user"
        val photo_url : String = "photo_url"
        val phone : String = "phone"
        val room : String = "room"
        val size : String = "size"
        val price : String = "price"
        val facilities : String = "facilities"
        val name : String = "name"
        val Authorization : String = "Authorization"
        val month: String = "month"
        val year: String = "year"
        val room_id : String = "room_id"
        val uang_diterima: String = "uang_diterima"
        val nominal: String="nominal"
        val uang_kembalian: String = "uang_kembalian"
        val content:String = "content"


    }

    var pref : SharedPreferences
    var editor : SharedPreferences.Editor? = null

    var context : Context?= null
    val PRIVATE_MODE : Int = 0

    init {
        this.context = context
        pref = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE)
        editor = pref.edit()
    }

    fun putString(key: String, value: String){
        editor!!.putString(key, value)
        editor!!.commit()
    }

    fun putInt(key : String, value: Int) {
        editor!!.putInt(key, value)
        editor!!.commit()
    }

    fun getString(key: String) : String{
        return pref.getString(key, "").toString()
    }

    fun getInt(key: String) : Int {
        return pref.getInt(key, 0)
    }


    fun isLogin() : Boolean{
        return getString(id_user).isNotEmpty()
    }

    fun Logout(){
        editor!!.clear()
        editor!!.commit()
    }
}