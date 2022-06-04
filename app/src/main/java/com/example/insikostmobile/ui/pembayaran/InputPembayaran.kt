package com.example.insikostmobile.ui.pembayaran

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.insikostmobile.data.db.Sessions
import com.example.insikostmobile.data.model.pembayaran.ResponsePayments
import com.example.insikostmobile.data.model.pembayaran.ResponsePembayaranItem
import com.example.insikostmobile.data.state.SimpleState
import com.example.insikostmobile.databinding.ActivityInputPembayaranBinding
import com.example.insikostmobile.root.App
import com.oratakashi.viewbinding.core.binding.activity.viewBinding
import com.oratakashi.viewbinding.core.tools.onClick
import com.oratakashi.viewbinding.core.tools.startActivity
import com.oratakashi.viewbinding.core.tools.toast
import dmax.dialog.SpotsDialog

class InputPembayaran : AppCompatActivity() {
    private lateinit var viewModel: PembayaranViewModel
    private val binding: ActivityInputPembayaranBinding by viewBinding()
    private val spotsDialog: SpotsDialog by lazy {
        SpotsDialog(this, "Mohon tunggu...")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_input_pelaporan)
//
//        val ButtonPay = findViewById<Button>(R.id.btnPay)
//        val InputMonth = findViewById<EditText>(R.id.tiMonth)
//        val InputYear = findViewById<EditText>(R.id.tiYear)
//        val InputNominal = findViewById<EditText>(R.id.tiNominal)
//        val InputPic = findViewById<EditText>(R.id.tiPic)
//
//        ButtonPay.setOnClickListener {
//            val nominal = InputNominal.text
//            val text = InputMonth.text
//
//        }

        setContentView(binding.root)
        viewModel = PembayaranViewModel()
        initListener()
        with(binding){
            btnPay.onClick {
                viewModel.postListPembayaran(
                    tiUserid.text.toString(),
                    tiRoomid.text.toString(),
                    tiMonth.text.toString(),
                    tiYear.text.toString(),
                    tiUangDiterima.text.toString(),
                    tiPhotoUrl.text.toString(),
                    tiNominal.text.toString(),

                    )
            }
//                if (tiUserid.text.toString()!= "" && tiNominal.text.toString() != "" && tiRoomid.text.toString() != "" &&  tiMonth.text.toString() != "" && tiYear.text.toString() != ""&& tiUangDiterima.text.toString() != ""&&tiPhotoUrl.text.toString() != ""){
//
//                }else{
//                    toast("Silahkan isi semua field")
//                }
//            }
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
                    if (it.data is ResponsePayments) {

                        App.sessions!!.putString(Sessions.month, it.data.month)
                        App.sessions!!.putString(Sessions.id_user,it.data.userId)
                        App.sessions!!.putString(Sessions.room_id,it.data.roomId)
                        App.sessions!!.putInt(Sessions.nominal,it.data.nominal)
                        App.sessions!!.putString(Sessions.year, it.data.year)
                        App.sessions!!.putInt(Sessions.uang_diterima, it.data.uangDiterima)
                        App.sessions!!.putString(Sessions.photo_url, it.data.photoUrl)


                        startActivity(Pembayaran::class.java)
                        finish()
                    }
                }
                is SimpleState.Error -> {
                    spotsDialog.dismiss()
                    toast("gagal")
                }
            }
        }
    }
}