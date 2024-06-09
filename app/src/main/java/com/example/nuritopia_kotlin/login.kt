package com.example.nuritopia_kotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.nuritopia_kotlin.databinding.ActivityLogin2Binding
import com.google.android.material.textfield.TextInputEditText

class login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login2)
        val emailField = findViewById<TextInputEditText>(R.id.emailField)
        val passwordField = findViewById<TextInputEditText>(R.id.passwordField)
        val loginButton = findViewById<Button>(R.id.login_btn)
        val registerNow = findViewById<TextView>(R.id.register_now)
        loginButton.setOnClickListener {
            val email = emailField.text.toString()
            val password = passwordField.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                val intent = Intent(this, Home::class.java)
                startActivity(intent)
            } else {
                if(email.isEmpty() && password.isEmpty()){
                    Toast.makeText(this, "Please enter your email & password", Toast.LENGTH_SHORT).show()
                }
                else if (email.isEmpty()) {
                    emailField.error = "Please enter your email"
                    Toast.makeText(this, "Please enter your email", Toast.LENGTH_SHORT).show()
                } else if (password.isEmpty()) {
                    Toast.makeText(this, "Please enter your password", Toast.LENGTH_SHORT).show()
                }
            }
        }
        registerNow.setOnClickListener{
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }
    }
}
