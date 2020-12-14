package com.example.sparl

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_homepage.*

class homepage : AppCompatActivity() {
    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.menuhome -> {

                return@OnNavigationItemSelectedListener true
            }
            R.id.menufav -> {

                return@OnNavigationItemSelectedListener true
            }
            R.id.menuaccount -> {

                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        HospitalButton1.setOnClickListener {
            val intent = Intent(this, search_hospital::class.java)
            startActivity(intent)
        }
        HospitalButton2.setOnClickListener {
            val intent = Intent(this, search_hospital::class.java)
            startActivity(intent)
        }
        ClinicButton1.setOnClickListener {
            val intent = Intent(this, search_clinic::class.java)
            startActivity(intent)
        }
        ClinicButton2.setOnClickListener {
            val intent = Intent(this, search_clinic::class.java)
            startActivity(intent)
        }
        viewDivider.setOnClickListener {
            val intent = Intent(this, User_Profile::class.java)
            startActivity(intent)
        }
    }
}