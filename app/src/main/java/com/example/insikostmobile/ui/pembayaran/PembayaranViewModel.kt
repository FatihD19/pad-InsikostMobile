package com.example.insikostmobile.ui.pembayaran

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.insikostmobile.data.state.SimpleState
import com.example.insikostmobile.root.App
import com.oratakashi.viewbinding.core.binding.livedata.liveData

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class PembayaranViewModel: ViewModel() {
    val state : MutableLiveData<SimpleState> by liveData()

    fun getListPembayaran(

    ) {
        App.service!!.getListPayments()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map<SimpleState>(SimpleState::Result)
            .onErrorReturn(SimpleState::Error)
            .toFlowable()
            .startWith(SimpleState.Loading)
            .subscribe(state::postValue)
            .let { return@let CompositeDisposable::add }
    }
    fun postListPembayaran(
        month: String,
        year: String,
        uang_diterima: String,
        photo_url: String,
        room_id: String,
        user_id: String,
        nominal: String,
    ) {
        App.service!!.postListPayments(user_id,nominal,room_id,month,year,uang_diterima,photo_url)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map<SimpleState>(SimpleState::Result)
            .onErrorReturn(SimpleState::Error)
            .toFlowable()
            .startWith(SimpleState.Loading)
            .subscribe(state::postValue)
            .let { return@let CompositeDisposable::add }
    }
}