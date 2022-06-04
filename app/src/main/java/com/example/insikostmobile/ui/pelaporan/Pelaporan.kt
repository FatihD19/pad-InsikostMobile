package com.example.insikostmobile.ui.pelaporan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.insikostmobile.R
import com.example.insikostmobile.data.model.pelaporan.ResponsePelaporanItem
import com.example.insikostmobile.data.model.pembayaran.ResponsePembayaranItem
import com.example.insikostmobile.data.state.SimpleState
import com.example.insikostmobile.databinding.ActivityPelaporanBinding
import com.example.insikostmobile.databinding.ActivityPembayaranBinding
import com.example.insikostmobile.ui.berita.Berita
import com.example.insikostmobile.ui.pembayaran.AdapterPembayaran
import com.example.insikostmobile.ui.pembayaran.Pembayaran
import com.example.insikostmobile.ui.pembayaran.PembayaranViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import com.oratakashi.viewbinding.core.binding.activity.viewBinding
import dmax.dialog.SpotsDialog

class Pelaporan : AppCompatActivity() {
    private lateinit var viewModel: PelaporanViewModel
    private val binding: ActivityPelaporanBinding by viewBinding()

    private val spotsDialog: SpotsDialog by lazy {
        SpotsDialog(this, "Mohon tunggu...")
    }
    private val adapter: AdapterPelaporan by lazy {
        AdapterPelaporan()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        viewModel = PelaporanViewModel()
        initListener()
        viewModel.getListComplaints()
        with(binding) {
            rvLapor.also {
                it.adapter = adapter
                it.layoutManager = LinearLayoutManager(this@Pelaporan)
            }
            setContentView(R.layout.activity_list_pelaporan)
            
        }
    }

    private fun initListener() {
        viewModel.state.observe(this) {
            when (it) {
                SimpleState.Loading -> {
                    spotsDialog.show()
                }
                is SimpleState.Result<*> -> {
                    spotsDialog.dismiss()
                    val data: List<ResponsePelaporanItem> = it.data as List<ResponsePelaporanItem>
                    adapter.submitData(data)
                }
                is SimpleState.Error -> {
                    spotsDialog.dismiss()
                }
            }
        }
    }

}