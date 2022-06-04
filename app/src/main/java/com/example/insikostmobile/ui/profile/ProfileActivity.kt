package com.example.insikostmobile.ui.profile

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import coil.load
import com.example.insikostmobile.R
import com.example.insikostmobile.data.db.Sessions
import com.example.insikostmobile.databinding.ActivityProfileBinding
import com.example.insikostmobile.root.App
import com.example.insikostmobile.ui.berita.Berita
import com.example.insikostmobile.ui.pelaporan.Pelaporan
import com.example.insikostmobile.ui.pembayaran.Pembayaran
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import com.oratakashi.viewbinding.core.binding.activity.viewBinding

class ProfileActivity : AppCompatActivity() {
    val binding: ActivityProfileBinding by viewBinding()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_profile)

        setContentView(binding.root)

        with(binding){
            tvKontak.text = App.sessions!!.getString(Sessions.phone)
            tvNama.text = App.sessions!!.getString(Sessions.name)
            ivProfile.load(App.sessions!!.getString(Sessions.photo_url))
            tvKamar.text = App.sessions!!.getString(Sessions.room)
            tvFasilitas.text = App.sessions!!.getString(Sessions.facilities)
            tvPrice.text = App.sessions!!.getInt(Sessions.price).toString()
            tvSize.text = App.sessions!!.getString(Sessions.size)

            // Initialize and assign variable

            // Initialize and assign variable
            val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
            // Set Home selected
            // Set Home selected
            bottomNavigationView.selectedItemId = R.id.Profil
            // Perform item selected listener
            // Perform item selected listener
            bottomNavigationView.setOnItemSelectedListener(NavigationBarView.OnItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.Pelaporan -> {
                        startActivity(Intent(applicationContext, Pelaporan::class.java))
                        overridePendingTransition(0, 0)
                        return@OnItemSelectedListener true
                    }
                    R.id.Profil -> return@OnItemSelectedListener true
                    R.id.Payment -> {
                        startActivity(Intent(applicationContext, Pembayaran::class.java))
                        overridePendingTransition(0, 0)
                        return@OnItemSelectedListener true
                    }
                    R.id.Berita -> {
                        startActivity(Intent(applicationContext, Berita::class.java))
                        overridePendingTransition(0, 0)
                        return@OnItemSelectedListener true
                    }
                }
                false
            })
        }
        }
    }
