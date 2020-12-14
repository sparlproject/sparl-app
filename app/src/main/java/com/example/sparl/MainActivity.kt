package com.example.sparl

import android.animation.Animator
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.text.TextUtils
import android.util.Patterns
import android.view.View
import android.view.View.VISIBLE
import android.view.Window
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_forgetpassword.*
import kotlinx.android.synthetic.main.activity_main.*


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
                rootView.setBackgroundColor(
                    ContextCompat.getColor(
                        this@MainActivity,
                        R.color.colorSplashText
                    )
                )
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

        btn_forgetpass.setOnClickListener{

            val builder = AlertDialog.Builder(this)
            builder.setTitle("Forgot Password")
            val view = layoutInflater.inflate(R.layout.activity_forgetpassword,null)
            val username = view.findViewById<EditText>(R.id.input_forgetemail)
            builder.setView(view)
            builder.setPositiveButton("Reset", DialogInterface.OnClickListener{_, _ ->
                      forgetPassword(username)
            })
            builder.setNegativeButton("close",DialogInterface.OnClickListener { _, _ ->
            })
            builder.show()

        }



    }

    private fun forgetPassword(username : EditText) {

        if (username.text.toString().isEmpty()){
            Toast.makeText(this,"Enter your email address", Toast.LENGTH_SHORT).show()

        }
        else if (!Patterns.EMAIL_ADDRESS.matcher(username.text.toString()).matches()){
            Toast.makeText(this,"Enter correct email address", Toast.LENGTH_SHORT).show()
        }
        else {
            auth.sendPasswordResetEmail(username.text.toString())
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "Email successfully sent", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(
                            this,
                            "Sorry your email is not registered !",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
        }

    }




    private fun login(){

        loginButton.setOnClickListener {

            if (TextUtils.isEmpty(email.text.toString())) {
                email.setError("Please enter your email")
                return@setOnClickListener
            }

            else if (TextUtils.isEmpty(passwordEditText.text.toString())) {
                passwordEditText.setError("Please enter your password")
                return@setOnClickListener
            }
            auth.signInWithEmailAndPassword(email.text.toString(), passwordEditText.text.toString())

                .addOnCompleteListener{
                    if(it.isSuccessful){
                        startActivity(Intent(this@MainActivity, homepage::class.java))
                        finish()
                    }
                    else{
                        Toast.makeText(this@MainActivity, "Invalid Credentials", Toast.LENGTH_LONG).show()
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

