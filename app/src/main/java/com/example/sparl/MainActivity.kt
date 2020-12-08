package com.example.sparl

import android.animation.Animator
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.text.TextUtils
import android.view.View
import android.view.View.VISIBLE
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_signup.*

class MainActivity : AppCompatActivity() {

    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_main)

        auth = FirebaseAuth.getInstance()
        login()

        object : CountDownTimer(5000, 1000) {
            override fun onFinish() {
                bookITextView.visibility = View.GONE
                loadingProgressBar.visibility = View.GONE
                rootView.setBackgroundColor(ContextCompat.getColor(this@MainActivity, R.color.colorSplashText))
                bookIconImageView.setImageResource(R.drawable.background_color_book)
                startAnimation()
            }
            override fun onTick(p0: Long) {}
        }.start()
        val textview: TextView = findViewById(R.id.signupbutton)
        textview.setOnClickListener {
            val intent = Intent(this@MainActivity, SignupActivity::class.java)
            startActivity(intent)
        }
    }

    private fun login(){

        loginButton.setOnClickListener {

            if (TextUtils.isEmpty(email.text.toString())) {
                email.setError("Please Enter Your Name")
                return@setOnClickListener
            } else if (TextUtils.isEmpty(passwordEditText.text.toString())) {
                passwordEditText.setError("Please Enter Your Email")
                return@setOnClickListener
            }
            auth.signInWithEmailAndPassword(email.text.toString(), passwordEditText.text.toString())

                .addOnCompleteListener{
                    if(it.isSuccessful){
                        startActivity(Intent(this@MainActivity, homepage::class.java))
                        finish()
                    }
                    else{
                        Toast.makeText(this@MainActivity, "Login failed, Please try again!", Toast.LENGTH_LONG).show()
                    }
                }
        }

    }

    private fun startAnimation() {
        bookIconImageView.animate().apply {
            x(50f)
            y(100f)
            duration = 1000
        }.setListener(object : Animator.AnimatorListener {
            override fun onAnimationRepeat(p0: Animator?) {

            }

            override fun onAnimationEnd(p0: Animator?) {
                afterAnimationView.visibility = VISIBLE
            }

            override fun onAnimationCancel(p0: Animator?) {

            }

            override fun onAnimationStart(p0: Animator?) {

            }
        })
    }
}

