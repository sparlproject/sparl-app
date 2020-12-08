package com.example.sparl

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import android.view.View
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_signup.*


class SignupActivity : AppCompatActivity() {

    lateinit var auth: FirebaseAuth
    var databaseReference : DatabaseReference? = null
    var database: FirebaseDatabase? = null

    var Button: Button? = null

    var _nameText: EditText? = null
    var _addressText: EditText? = null
    var _emailText: EditText? = null
    var _mobileText: EditText? = null
    var _passwordText: EditText? = null
    var _reEnterPasswordText: EditText? = null
    var _signupButton: Button? = null
    var _loginLink: TextView? = null

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()
        databaseReference = database?.reference!!.child("profile")

        register()
     }

    private fun register(){

        btnhome.setOnClickListener{

            if(TextUtils.isEmpty(input_name.text.toString())){
                input_name.setError("Please Enter Your Name")
                return@setOnClickListener
            }
            else if(TextUtils.isEmpty(input_email.text.toString())){
                input_email.setError("Please Enter Your Email")
                return@setOnClickListener
            }
            else if(TextUtils.isEmpty(input_password.text.toString())){
                input_password.setError("Please Enter Password")
                return@setOnClickListener
            }
            else if(TextUtils.isEmpty(input_reEnterPassword.text.toString())){
                input_reEnterPassword.setError("Please Enter Password Again")
                return@setOnClickListener
            }

            auth.createUserWithEmailAndPassword(input_email.text.toString(),input_password.text.toString())

                .addOnCompleteListener{
                    if(it.isSuccessful){
                        val currentUser = auth.currentUser
                        val currentUserDb = databaseReference?.child((currentUser?.uid!!))
                        currentUserDb?.child("Name")?.setValue(input_name.text.toString())

                        Toast.makeText(this@SignupActivity, "Registration Success", Toast.LENGTH_LONG).show()
                        finish()
                    } else{
                        Toast.makeText(this@SignupActivity, "Registration failed, Please try again!", Toast.LENGTH_LONG).show()
                    }
                }

        }
    }




    }
