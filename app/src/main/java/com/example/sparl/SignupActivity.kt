package com.example.sparl

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast


class SignupActivity : AppCompatActivity() {

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


    }

    fun signup() {

    }
}