package com.example.sparl

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_homepage.*
import kotlinx.android.synthetic.main.activity_user_profile.*

class User_Profile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)

        UserButton1.setOnClickListener {
            val intent = Intent(this, Edit_Profile::class.java)
            startActivity(intent)
        }
        UserButton2.setOnClickListener {
            val intent = Intent(this, Edit_Profile::class.java)
            startActivity(intent)
        }
        UserButton3.setOnClickListener {
            val intent = Intent(this, Edit_Profile::class.java)
            startActivity(intent)
        }
        UserButton4.setOnClickListener {
            val intent = Intent(this, About::class.java)
            startActivity(intent)
        }
    }
}