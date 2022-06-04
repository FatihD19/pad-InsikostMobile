package com.example.insikostmobile.ui.pembayaran

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.insikostmobile.data.db.Sessions
import com.example.insikostmobile.data.model.pembayaran.ResponsePembayaranItem
import com.example.insikostmobile.databinding.ActivityListPembayaranBinding
import com.example.insikostmobile.root.App
import com.oratakashi.viewbinding.core.binding.recyclerview.ViewHolder
import com.oratakashi.viewbinding.core.binding.recyclerview.viewBinding

class AdapterPembayaran : RecyclerView.Adapter<ViewHolder<ActivityListPembayaranBinding>>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder<ActivityListPembayaranBinding> = viewBinding(parent)

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder<ActivityListPembayaranBinding>, position: Int) {
        val dataPembayaranRoom: ResponsePembayaranItem = data[position]

        with(holder.binding) {
            tvNamaKamar.text = dataPembayaranRoom.dataPembayaranRoom.name
            tvDate.text = dataPembayaranRoom.createdAt
            tvNamaPenghuni.text = dataPembayaranRoom.dataPembayaranUser.name
            tvNominal.text = dataPembayaranRoom.nominal.toString()
            tvMonth.text = dataPembayaranRoom.month
            tvYear.text = dataPembayaranRoom.year
            ivPembayaran.load(dataPembayaranRoom.dataPembayaranRoom.photoUrl)
            tvstatus.text = dataPembayaranRoom.status

        }
    }

    override fun getItemCount(): Int = data.size

    @SuppressLint("NotifyDataSetChanged")
    fun submitData(data: List<ResponsePembayaranItem>) {
        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    private val data: MutableList<ResponsePembayaranItem> = ArrayList()
}