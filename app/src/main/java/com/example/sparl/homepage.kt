package com.example.sparl

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_homepage.*

class homepage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)
        val firstFragment=Home_Fragment()
        val secondFragment=Predictor_Fragment()
        val thirdFragment=UserProfile_Fragment()

        setCurrentFragment(firstFragment){

    }

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home->setCurrentFragment(firstFragment)
                R.id.menufav->setCurrentFragment(secondFragment)
                R.id.menuaccount->setCurrentFragment(thirdFragment)

            }
            true
        }
        private fun setCurrentFragment(fragment: Fragment)=
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment,fragment)
                commit()
            }

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


}