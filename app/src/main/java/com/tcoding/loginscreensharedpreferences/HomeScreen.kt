package com.tcoding.loginscreensharedpreferences

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tcoding.loginscreensharedpreferences.databinding.ActivityHomeScreenBinding

class HomeScreen : AppCompatActivity() {
    lateinit var binding: ActivityHomeScreenBinding
    lateinit var sharedPreferences: SharedPreferences
    val FILE_NAME = "com.tcoding.loginscreensharedpreferences"
    val USERNAME = "username"
    val PASSWORD = "password"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = this.getSharedPreferences(FILE_NAME, MODE_PRIVATE)


        binding.textViewUsername.text  = sharedPreferences.getString(USERNAME,"")
        binding.textViewPassword.text  = sharedPreferences.getString(PASSWORD,"")

        binding.buttonCikis.setOnClickListener {
            sharedPreferences.edit().clear().apply()
            startActivity(Intent(applicationContext,MainActivity::class.java))
        }


    }
}