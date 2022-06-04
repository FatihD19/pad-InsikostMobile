package com.example.insikostmobile.ui.pelaporan

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.insikostmobile.data.model.pelaporan.ResponsePelaporanItem
import com.example.insikostmobile.data.model.pembayaran.ResponsePembayaranItem
import com.example.insikostmobile.databinding.ActivityListPelaporanBinding
import com.example.insikostmobile.databinding.ActivityListPembayaranBinding
import com.oratakashi.viewbinding.core.binding.recyclerview.ViewHolder
import com.oratakashi.viewbinding.core.binding.recyclerview.viewBinding

class AdapterPelaporan : RecyclerView.Adapter<ViewHolder<ActivityListPelaporanBinding>>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder<ActivityListPelaporanBinding> = viewBinding(parent)

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder<ActivityListPelaporanBinding>, position: Int) {
        val dataPelaporanUser: ResponsePelaporanItem = data[position]

        with(holder.binding) {
            tvNama.text = dataPelaporanUser.dataPelaporanUser.name
            tvCreateAt.text = dataPelaporanUser.createdAt
            tvIsiLapor.text = dataPelaporanUser.content

        }

    }

    override fun getItemCount(): Int = data.size

    @SuppressLint("NotifyDataSetChanged")
    fun submitData(data: List<ResponsePelaporanItem>) {
        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    private val data: MutableList<ResponsePelaporanItem> = ArrayList()
}