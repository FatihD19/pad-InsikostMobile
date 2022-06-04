package com.example.insikostmobile.root

import android.app.Application
import com.example.insikostmobile.data.db.Sessions
import com.example.insikostmobile.data.network.ApiService
import io.reactivex.disposables.CompositeDisposable

class App : Application() {

    companion object {
        var service: ApiService? = null
        lateinit var disposable: CompositeDisposable

        var sessions: Sessions? = null


        val server: String = "http://192.168.100.172:8000/api/"
    }

    override fun onCreate() {
        super.onCreate()

        service = ApiService()
        disposable = CompositeDisposable()
        sessions = Sessions(this)

    }

}