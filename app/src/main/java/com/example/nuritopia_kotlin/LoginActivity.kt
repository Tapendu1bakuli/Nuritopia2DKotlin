package com.example.nuritopia_kotlin

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        val loginButtonClick = findViewById<Button>(R.id.login_btn)
        loginButtonClick.setOnClickListener{
            val intent = Intent(this, login::class.java)
            startActivity(intent)
        }
        val registerButtonClick = findViewById<Button>(R.id.register_btn)
        registerButtonClick.setOnClickListener{
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }

    }
}