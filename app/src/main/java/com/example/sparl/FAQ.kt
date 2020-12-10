package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_faq1)
        val button =
            findViewById<View>(R.id.button) as Button
        val button1 =
            findViewById<View>(R.id.button2) as Button
        val button2 =
            findViewById<View>(R.id.button3) as Button
        val button3 =
            findViewById<View>(R.id.button4) as Button
        button.setOnClickListener {
            val int2 = Intent(this@MainActivity, SECOND::class.java)
            startActivity(int2)
        }
        button1.setOnClickListener {
            val int2 = Intent(this@MainActivity, THIRD::class.java)
            startActivity(int2)
        }
        button2.setOnClickListener {
            val int2 = Intent(this@MainActivity, FOURTH::class.java)
            startActivity(int2)
        }
        button3.setOnClickListener {
            val int2 = Intent(this@MainActivity, FIFTH::class.java)
            startActivity(int2)
        }
    }
}