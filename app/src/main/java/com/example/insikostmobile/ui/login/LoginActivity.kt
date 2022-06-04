package com.example.insikostmobile.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.insikostmobile.data.db.Sessions
import com.example.insikostmobile.data.model.login.ResponeLogin
import com.example.insikostmobile.data.state.SimpleState
import com.example.insikostmobile.databinding.ActivityLoginBinding
import com.example.insikostmobile.root.App
import com.example.insikostmobile.ui.pelaporan.Pelaporan
import com.example.insikostmobile.ui.pembayaran.InputPembayaran
import com.example.insikostmobile.ui.pembayaran.Pembayaran
import com.example.insikostmobile.ui.profile.ProfileActivity
import com.oratakashi.viewbinding.core.binding.activity.viewBinding
import com.oratakashi.viewbinding.core.tools.onClick
import com.oratakashi.viewbinding.core.tools.startActivity
import com.oratakashi.viewbinding.core.tools.toast
import dmax.dialog.SpotsDialog

class LoginActivity : AppCompatActivity() {
    private lateinit var viewModel: LoginViewModel
    private val binding: ActivityLoginBinding by viewBinding()
    private val spotsDialog: SpotsDialog by lazy {
        SpotsDialog(this, "Mohon tunggu...")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        viewModel = LoginViewModel()
        initListener()
        with(binding){
            btnLogin.onClick {
                if (etPhone.text.toString() != "" && etPasswordLogin.text.toString() != ""){
                    viewModel.login(
                        etPhone.text.toString(),
                        etPasswordLogin.text.toString()
                    )
                }else{
                    toast("Silahkan isi semua field")
                }
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
                    if (it.data is ResponeLogin) {
                        App.sessions!!.putString(Sessions.id_user, it.data.dataUser.id)
                        App.sessions!!.putString(Sessions.room_id,it.data.dataUser.dataRoom.id)
                        App.sessions!!.putString(Sessions.name, it.data.dataUser.name)
                        App.sessions!!.putString(Sessions.photo_url, it.data.dataUser.photoUrl)
                        App.sessions!!.putString(Sessions.room, it.data.dataUser.dataRoom.name)
                        App.sessions!!.putString(Sessions.size, it.data.dataUser.dataRoom.size)
                        App.sessions!!.putInt(Sessions.price, it.data.dataUser.dataRoom.price)
                        App.sessions!!.putString(Sessions.facilities, it.data.dataUser.dataRoom.dataFacilities[0].name)
                        App.sessions!!.putString(Sessions.phone, it.data.dataUser.phone)
                        App.sessions!!.putString(Sessions.Authorization, it.data.accessToken)
                        startActivity(InputPembayaran::class.java)
                        finish()
                    }
                }
                is SimpleState.Error -> {
                    spotsDialog.dismiss()
                }
            }
        }
    }
}