package com.example.insikostmobile.ui.pembayaran

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.insikostmobile.R
import com.example.insikostmobile.data.db.Sessions
import com.example.insikostmobile.data.model.login.ResponeLogin
import com.example.insikostmobile.data.model.pembayaran.ResponsePembayaranItem
import com.example.insikostmobile.data.state.SimpleState
import com.example.insikostmobile.databinding.ActivityLoginBinding
import com.example.insikostmobile.databinding.ActivityPembayaranBinding
import com.example.insikostmobile.root.App
import com.example.insikostmobile.ui.login.LoginViewModel
import com.example.insikostmobile.ui.profile.ProfileActivity
import com.oratakashi.viewbinding.core.binding.activity.viewBinding
import com.oratakashi.viewbinding.core.tools.startActivity
import dmax.dialog.SpotsDialog

class Pembayaran : AppCompatActivity() {
    private lateinit var viewModel: PembayaranViewModel
    private val binding: ActivityPembayaranBinding by viewBinding()
    private val spotsDialog: SpotsDialog by lazy {
        SpotsDialog(this, "Mohon tunggu...")
    }
    private val adapter: AdapterPembayaran by lazy {
        AdapterPembayaran()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        viewModel = PembayaranViewModel()
        initListener()
        viewModel.getListPembayaran()
        with(binding) {
            rvPay.also {
                it.adapter = adapter
                it.layoutManager = LinearLayoutManager(this@Pembayaran)
            }
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
                    val data: List<ResponsePembayaranItem> = it.data as List<ResponsePembayaranItem>
                    adapter.submitData(data)
                }
                is SimpleState.Error -> {
                    spotsDialog.dismiss()
                }
            }
        }
    }

}