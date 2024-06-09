package com.example.nuritopia_kotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.material.textfield.TextInputEditText

class Register : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        val loginNow = findViewById<TextView>(R.id.login_now)
        val emailField = findViewById<TextInputEditText>(R.id.emailField)
        val passwordField = findViewById<TextInputEditText>(R.id.passwordField)
        val confirmPasswordField = findViewById<TextInputEditText>(R.id.confirmPasswordField)
        val registerNow = findViewById<Button>(R.id.login_btn)
        setSupportActionBar(toolbar)

        // Set the click listener for the back button
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
        loginNow.setOnClickListener{
            val intent = Intent(this, login::class.java)
            startActivity(intent)
        }
        registerNow.setOnClickListener {
            val email = emailField.text.toString()
            val password = passwordField.text.toString()
            val confirmPassword = confirmPasswordField.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty() && confirmPassword.isNotEmpty()) {
                if(password == confirmPassword){
                    val intent = Intent(this, Home::class.java)
                    startActivity(intent)
                }else{
                    Toast.makeText(this, "Password & confirm password should be same.", Toast.LENGTH_SHORT).show()
                }
            } else {
                if(email.isEmpty() && password.isEmpty() && confirmPassword.isEmpty()){
                    Toast.makeText(this, "Please provide email & password", Toast.LENGTH_SHORT).show()
                }
                else if (email.isEmpty()) {
                    emailField.error = "Please enter your email"
                    Toast.makeText(this, "Please enter your email", Toast.LENGTH_SHORT).show()
                } else if (password.isEmpty()) {
                    Toast.makeText(this, "Please enter your password", Toast.LENGTH_SHORT).show()
                } else if (confirmPassword.isEmpty()){
                    Toast.makeText(this, "Please enter confirm password", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }
}