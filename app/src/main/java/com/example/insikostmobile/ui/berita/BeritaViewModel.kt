package com.example.insikostmobile.ui.berita

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.insikostmobile.data.state.SimpleState
import com.example.insikostmobile.root.App
import com.oratakashi.viewbinding.core.binding.livedata.liveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class BeritaViewModel : ViewModel() {
    val state: MutableLiveData<SimpleState> by liveData()

    fun getListBerita(

    ) {
        App.service!!.getListNews()
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